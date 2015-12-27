package com.jeizas.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String home(){
		return "homeb";
	}
	
	/**
	 * 商家餐品管理
	 * @return
	 */
	@RequestMapping(value="fadd",method=RequestMethod.GET)
	public String food(){
		return "addfood";
	}
	/**
	 * 商家餐品管理
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
}
