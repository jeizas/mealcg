package com.jeizas.controller;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jeizas.dto.CartDTO;
import com.jeizas.dto.OrderDTO;
import com.jeizas.entity.Food;
import com.jeizas.entity.Like;
import com.jeizas.entity.Order;
import com.jeizas.entity.User;
import com.jeizas.service.FoodService;
import com.jeizas.service.LikeService;
import com.jeizas.service.OrderService;
import com.jeizas.service.UserService;
import com.jeizas.utils.Constants;
import com.jeizas.utils.ErrorCodes;
import com.jeizas.utils.SessionKeys;

@Controller
public class UserAction implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(UserAction.class); 
	
	public static final String INDEX = "index";
	public static final String CART = "cart";
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private UserService userService;
	@Autowired
	private  LikeService likeService;
	
	/**
	 * 用户个人中心
	 * @return
	 */
	@RequestMapping(value="/uhome",method=RequestMethod.GET)
	public String home(HttpSession session, Model model){
		String retString = null;
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId > 0){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			model.addAttribute("user", user);
			model.addAttribute("url", Constants.URER_FACE_URL+usrId+"/"+usrId+".jpg");
			retString = "homeu";
		} else{
			retString = "index";
		}
		return retString;
	}

	/**
	 * 我的订单
	 * @return
	 */
	@RequestMapping(value="/uorder",method=RequestMethod.GET)
	public String order(HttpSession session, Model model){
		return "orderu";
	}
	
	/**
	 * 我的订单页面的数据
	 * @return
	 */
	@RequestMapping(value="/dtlo",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> orderd(HttpSession session, Model model){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<OrderDTO> retDto = new ArrayList<OrderDTO>();
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			List<Order> list = orderService.selectOrderByUserId(usrId);
			for(Order o:list){
				Food food = foodService.findRecordByProperty(Food.FIELD_ID, o.getFoodId());
				OrderDTO od = new OrderDTO(o, food, user);
				retDto.add(od);
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		retMap.put("list", retDto);
		return retMap;
	}
	
	/**
	 * 我的收藏
	 * @return
	 */
	@RequestMapping(value="/ucollect",method=RequestMethod.GET)
	public String collect(){
		return "collectu";
	}
	/**
	 * 我的地址
	 * @return
	 */
	@RequestMapping(value="/uaddr",method=RequestMethod.GET)
	public String addr(){
		return "addru";
	}
	/**
	 * 用户打开购物车
	 * @return
	 */
	@RequestMapping(value="/ucart",method=RequestMethod.GET)
	public String cart(HttpSession session, Model model){
		String retString = null;
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<CartDTO> carts = new ArrayList<CartDTO>();
		Integer sum = 0;
		if(usrId != null){
			List<Order> list = orderService.cartOrder(usrId);
			for(int i=0; i<list.size();i++){
				Food food = foodService.findRecordByProperty(Food.FIELD_ID, list.get(i).getFoodId());
				CartDTO cart = new CartDTO(list.get(i) ,food);
				carts.add(cart);
				sum = sum + food.getMoney()*list.get(i).getCount(); 
			}
			model.addAttribute("count", carts == null ? 0 : carts.size());
			retString = "cartu";
		} else{
			retString = "index";
		}
		model.addAttribute("carts", carts);
		model.addAttribute("sum", sum);
		model.addAttribute("pageType", CART);
		return retString;
	}
	
	/**
	 * 用户打开购物车
	 * @return
	 */
	@RequestMapping(value="cntUrd",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> cntUrd(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<Order> list = null;
		if(usrId != null){
			list = orderService.cartOrder(usrId);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		retMap.put("count",list == null ? 0 : list.size());
		return retMap;
	}
	/**
	 * 添加购物车
	 * @return
	 */
	@RequestMapping(value="/addcart",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addcart(HttpSession session, Integer foodId){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			Order order = new Order(usrId, foodId);
			if(orderService.save(order) == null){
				errorCode = ErrorCodes.INVALID_DB_INSERT;
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 删除购物车中的食物
	 * @return
	 */
	@RequestMapping(value="/mfood",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> mfood(HttpSession session, Integer id, Integer count){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			Order order = orderService.findRecordByProperty(Order.FIELD_ID, id);
			order.setCount(count);
			if(orderService.update(order) != null){
				logger.info("用户USRID["+usrId+"]更新购物车成功！");
			} else{
				errorCode = ErrorCodes.INVALID_DB_UPDATE;
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 删除购物车
	 * @return
	 */
	@RequestMapping(value="/dorder",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> dorder(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Integer money = 0;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			Order order = orderService.findRecordByProperty(Order.FIELD_ID, id);
			order.setDeleted(Constants.DELETED_YES);
			orderService.update(order);
			Food food = foodService.findRecordByProperty(Food.FIELD_ID, order.getFoodId());
			money = food.getMoney() * order.getCount();
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		retMap.put("money", money);
		return retMap;
	}
	
	/**
	 * 添加收藏
	 * @return
	 */
	@RequestMapping(value="/likeIt",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> likeIt(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			errorCode = likeService.likeIt(usrId, id);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 添加收藏
	 * @return
	 */
	@RequestMapping(value="/likenot",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> likenot(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			errorCode = likeService.likenot(usrId, id);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 我的收藏页面的数据
	 * @return
	 */
	@RequestMapping(value="/ldtl",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> likedtl(HttpSession session, Model model){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<OrderDTO> retDto = new ArrayList<OrderDTO>();
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			List<Like> list = likeService.findUndeletedRecordsByProperty(Order.FIELD_USR_ID, usrId);
			for(Like l:list){
				Food food = foodService.findRecordByProperty(Food.FIELD_ID, l.getFoodId());
				OrderDTO od = new OrderDTO(l, food, user);
				retDto.add(od);
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		retMap.put("list", retDto);
		return retMap;
	}
	
	/**
	 * 删除订单
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/subcart",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> subcart(HttpSession session){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			orderService.subCart(usrId);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 用户修改头像
	 * @param session
	 * @param flag
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/filepro",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> filepro(HttpSession session, MultipartFile file, HttpServletRequest request) throws IOException{
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		Integer errorCode = ErrorCodes.SUCCESS;
		String url = null;
		if(usrId != null){
			if(file != null){
				logger.info(file.getName());
				String realpath = request.getSession().getServletContext().getRealPath(Constants.URER_FACE_URL)+usrId;//得到文件夹路径
				File tmp = new File(realpath);//判断该文件夹是名是否存在
				if(!tmp.exists()  && !tmp.isDirectory()) {   
				    	System.out.println("//文件夹不存在，已创建");
				    	tmp.mkdir();      
				}
				String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
				File f=new File(realpath+"/"+usrId+suffix);//判断文件名是否存在  以要上传的文件路径和新建文件
				FileUtils.copyInputStreamToFile(file.getInputStream(),f);
				url = Constants.URER_FACE_URL +usrId+"/"+f.getName();
			} else{
				errorCode = ErrorCodes.INVALID_PARAM;
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		retMap.put("url", url);
		return retMap;
	}
}
