package com.jeizas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
			List<Order> list = orderService.findUndeletedRecordsByProperty(Order.FIELD_USR_ID, usrId);
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
			List<Order> list = orderService.findUndeletedRecordsByProperty(Order.FIELD_USR_ID, usrId);
			for(int i=0; i<list.size();i++){
				Food food = foodService.findRecordByProperty(Food.FIELD_ID, list.get(i).getFoodId());
				CartDTO cart = new CartDTO(list.get(i) ,food);
				carts.add(cart);
				sum = sum + food.getMoney()*list.get(i).getCount(); 
			}
			retString = "cartu";
		} else{
			retString = "homeu";
		}
		model.addAttribute("carts", carts);
		model.addAttribute("sum", sum);
		return retString;
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
	 * 添加购物车
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
			for(Like o:list){
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
}
