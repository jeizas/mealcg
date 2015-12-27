package com.jeizas.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
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
import com.jeizas.utils.StringUtil;

@Controller
public class LoginAction implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginAction.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 * @param email
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> login(String email, String pwd,Integer type, HttpSession session){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String,Object> retMap = new HashMap<String,Object>();
		if(StringUtil.isAllValid(email) && StringUtil.isAllValid(pwd)){
			logger.info("Email["+email+"]正在登...");
			User user = userService.findUser(email, pwd, type);
			if(user != null){
				session.setAttribute(SessionKeys.USER_ID, user.getId());
				session.setAttribute(SessionKeys.USER_NICK, user.getNick());
				session.setAttribute(SessionKeys.USER_NAME, user.getName());
				session.setAttribute(SessionKeys.BUS_FLAG, user.getFlag());
			}else {
				errorCode = ErrorCodes.INVALID_LOGIN;
			}
		}else{
			errorCode = ErrorCodes.INVALID_PARAM;
		}
		
		retMap.put("errorCode",errorCode);
		return retMap;
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param session
	 * @param email
	 * @param pwd
	 * @return
	 */
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> regest(HttpServletRequest request, HttpSession session,String email, String pwd, Integer type){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String,Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isValid(email) && StringUtil.isAllValid(pwd) && type !=null && type > 0){
			logger.info("Email["+email+"]正在注册...");
			User user = new User(email, pwd,request.getRemoteAddr());
			user.setGrpId(type);
			if(type == User.TYPE_BUSINESS){
				user.setName("我的店铺");
				user.setFlag(User.FLAG_NO);
			}
			User tmp = userService.insert(user);
			if(tmp != null){
				session.setAttribute(SessionKeys.USER_ID, tmp.getId());
				session.setAttribute(SessionKeys.USER_NICK, tmp.getNick());
			}else{
				errorCode = ErrorCodes.INVALID_DB_INSERT;
			}
		}else{
			errorCode = ErrorCodes.INVALID_PARAM;
		}
		retMap.put("errorCode",errorCode);
		return retMap;
	}
	/**
	 * 用户注销
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request){
		logger.info("["+session.getAttribute(SessionKeys.USER_ID)+"]注销登录...");
		session.invalidate();
		return "redirect:/";
	}
}
