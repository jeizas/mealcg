package com.jeizas.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeizas.entity.User;
import com.jeizas.service.UserService;
import com.jeizas.utils.ErrorCodes;
import com.jeizas.utils.SessionKeys;

@Controller
public class BusinessAction implements Serializable{

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(BusinessAction.class);
	
	@Autowired
	private UserService userService;
	
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
	 * 商家餐品管理
	 * @return
	 */
	@RequestMapping(value="bmenu",method=RequestMethod.GET)
	public String menu(){
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
	public String food(){
		return "addfood";
	}
	/**
	 * 商家修改店铺名字
	 * @return
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
			} else {
				errorCode = ErrorCodes.INVALID_PARAM;
			}
		} else{
			errorCode = ErrorCodes.NOT_LOGIN;
		}
		retMap.put("errorCode", errorCode);
		return retMap;
	}
}
