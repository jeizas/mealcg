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

import com.jeizas.dto.OrderDTO;
import com.jeizas.entity.Food;
import com.jeizas.entity.Order;
import com.jeizas.entity.User;
import com.jeizas.service.FoodService;
import com.jeizas.service.OrderService;
import com.jeizas.service.UserService;
import com.jeizas.utils.Constants;
import com.jeizas.utils.ErrorCodes;
import com.jeizas.utils.SessionKeys;

@Controller
public class BusinessAction implements Serializable{

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(BusinessAction.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private OrderService orderService;
	
	/**
	 * 商家登录
	 * @return
	 */
	@RequestMapping(value="indexb",method=RequestMethod.GET)
	public String login(){
		return "loginb";
	}
	
	/**
	 * 商家订单管理
	 * @return
	 */
	@RequestMapping(value="border",method=RequestMethod.GET)
	public String order(){
		return "orderb";
	}
	/**
	 * 用户提交的订单
	 * @return
	 */
	@RequestMapping(value="dorder",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> dorder(HttpSession session){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<OrderDTO> retDto = new ArrayList<OrderDTO>(); 
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			List<Order> order = orderService.findSubmitOrder(user.getId(), Order.STATE_DEF);
			for(Order o:order){
				Food food = foodService.findRecordByProperty(Food.FIELD_ID, o.getFoodId());
				if(food != null){
					OrderDTO dto = new OrderDTO(o, food, user);
					retDto.add(dto);
				}
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("list", retDto);
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	/**
	 * 商家已经接受的订单
	 * @return
	 */
	@RequestMapping(value="aorder",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> corder(HttpSession session){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<OrderDTO> retDto = new ArrayList<OrderDTO>(); 
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			List<Order> order = orderService.findSubmitOrder(user.getId(), Order.STATE_ACC);
			for(Order o:order){
				Food food = foodService.findRecordByProperty(Food.FIELD_ID, o.getFoodId());
				if(food != null){
					OrderDTO dto = new OrderDTO(o, food, user);
					retDto.add(dto);
				}
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("list", retDto);
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	/**
	 * 商家已经完成的订单
	 * @return
	 */
	@RequestMapping(value="sorder",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> forder(HttpSession session){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<OrderDTO> retDto = new ArrayList<OrderDTO>(); 
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			List<Order> order = orderService.findSubmitOrder(user.getId(), Order.STATE_SUC);
			for(Order o:order){
				Food food = foodService.findRecordByProperty(Food.FIELD_ID, o.getFoodId());
				if(food != null){
					OrderDTO dto = new OrderDTO(o, food, user);
					retDto.add(dto);
				}
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("list", retDto);
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 商家接受订单
	 */
	@RequestMapping(value="odacc",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> odacc(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			Order order = orderService.findRecordByProperty(User.FIELD_ID, id);
			order.setState(Order.STATE_ACC);
			orderService.update(order);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 商家拒绝订单
	 */
	@RequestMapping(value="odrej",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> odrej(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			Order order = orderService.findRecordByProperty(Order.FIELD_ID, id);
			order.setState(Order.STATE_REJ);
			orderService.update(order);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 商家完成订单
	 */
	@RequestMapping(value="odsuc",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> odsuc(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			Order order = orderService.findRecordByProperty(Order.FIELD_ID, id);
			order.setState(Order.STATE_SUC);
			orderService.update(order);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 商家餐品管理
	 * @return
	 */
	@RequestMapping(value="bmenu",method=RequestMethod.GET)
	public String menu(HttpSession session, Model model){
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		List<Food> tmp = null;
		if(usrId != null){
			tmp = foodService.findUndeletedRecordsByProperty(Food.FIELD_BUSID, usrId);
		} else{
			tmp = null;
		}
		model.addAttribute("foods", tmp);
		return "menub";
	}
	
	/**
	 * 商家个人中心
	 * @return
	 */
	@RequestMapping(value="bhome",method=RequestMethod.GET)
	public String home(HttpSession session, Model model){
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			model.addAttribute("user", user);
			return "homeb";
		}else{
			return "loginb";
		}
		
	}
	
	/**
	 * 商家餐品管理
	public String order(){
	 * @return
	 */
	@RequestMapping(value="fadd",method=RequestMethod.GET)
	public String food(Model model,HttpSession session){
		String retString = null;
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			Food food = foodService.findNofinishRecord(user.getId());
			if(food == null){
				food = new Food(user);
				foodService.insert(food);
			}
			model.addAttribute("food", food);
			retString = "addfood";
		} else{
			retString = "loginb";
		}
		return retString;
	}
	/**
	 * 商家修改店铺名字
	 * @returnpublic User findUser(String email, String pwd, Integer type){
		return getDao().findUser(email, pwd, type);
	}
	 */
	@RequestMapping(value="mname",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> modifyMame(HttpSession session, String name){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer errorCode = ErrorCodes.SUCCESS;
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			logger.info("用户ID["+user.getId()+"]正在修改店铺名字“"+name+"”");
			user.setName(name);
			userService.update(user);
		} else {
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	/**
	 * 商家修改电话号码
	 * @return
	 */
	@RequestMapping(value="mphone",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> modifyPhone(HttpSession session, String phone){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer errorCode = ErrorCodes.SUCCESS;
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			logger.info("用户ID["+user.getId()+"]正在修改店铺电话号码“"+phone+"”");
			user.setPhone(phone);
			userService.update(user);
		} else {
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	/**
	 * 商家修改地址
	 * @return
	 */
	@RequestMapping(value="maddr",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> modifyAddr(HttpSession session, String addr){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer errorCode = ErrorCodes.SUCCESS;
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			logger.info("用户ID["+user.getId()+"]正在修改店铺地址“"+addr+"”");
			user.setAddr(addr);
			userService.update(user);
		} else {
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	
	/**
	 * 商家选择是否接单
	 * @param session
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="isRec",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> isRec(HttpSession session, Integer flag){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		Integer errorCode = ErrorCodes.SUCCESS;
		if(usrId != null){
			if(flag != null){
				User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
				user.setFlag(flag);
				userService.update(user);
			} else {
				errorCode = ErrorCodes.INVALID_PARAM;
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
	/**
	 * 商家添加新餐品
	 */
	@RequestMapping(value="/addfood",method=RequestMethod.POST)
	public String addfood(Food food, Integer id, HttpServletRequest request,Model model) throws IOException{
		String retString = null;
		Integer usrId = (Integer) request.getSession().getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			User user = userService.findRecordByProperty(User.FIELD_ID, usrId);
			Food tmp = foodService.findRecordByProperty("id", id);
			if(foodService.updateFood(tmp, food) != null){
				logger.info("商家[USRID:"+user.getId()+"正在增加新的餐品[ID:"+food.getId()+"],餐品名称["+food.getName()+"]！");//显示要上传的文件名
				retString = "menub";
			}
		} else{
			retString = "loginb";
		}
		return retString;
	}
	/**
	 * 商家上传餐品图片
	 * @param session
	 * @param flag
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/upface",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> upface(HttpSession session, MultipartFile file, HttpServletRequest request,Integer foodId) throws IOException{
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		Integer errorCode = ErrorCodes.SUCCESS;
		String url = null;
		if(usrId != null){
			if(file != null && foodId != null){
				logger.info(file.getName());
				String realpath = request.getSession().getServletContext().getRealPath(Constants.FOOD_URL)+foodId;//得到文件夹路径
				File tmp = new File(realpath);//判断该文件夹是名是否存在
				if(!tmp.exists()  && !tmp.isDirectory()) {   
				    	System.out.println("//文件夹不存在，已创建");
				    	tmp.mkdir();      
				}
				String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
				File f=new File(realpath+"/"+foodId+suffix);//判断文件名是否存在  以要上传的文件路径和新建文件
				FileUtils.copyInputStreamToFile(file.getInputStream(),f);
				Food food = foodService.findRecordByProperty("id", foodId);
				food.setImg(f.getName());
				if(foodService.update(food) != null){
					url = "/resource/mealface/"+food.getId()+"/"+f.getName();
				} else{
					errorCode = ErrorCodes.INVALID_DB_INSERT;
				}
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
	
	/**
	 * 商家删除食物
	 */
	@RequestMapping(value="dfood",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> dfood(HttpSession session, Integer id){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		if(usrId != null){
			Food food = foodService.findRecordByProperty(Food.FIELD_ID, id);
			food.setDeleted(Constants.DELETED_YES);
			foodService.update(food);
			orderService.deletedOrderByFoodId(id);
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
}
