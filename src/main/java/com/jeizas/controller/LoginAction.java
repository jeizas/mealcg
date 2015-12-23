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
import com.jeizas.utils.StringUtil;

@Controller
public class LoginAction implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginAction.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> login(String email, String pwd, HttpSession session){
		Integer errorCode = ErrorCodes.SUCCESS;
		Map<String,Object> retMap = new HashMap<String,Object>();
		if(StringUtil.isAllValid(email) && StringUtil.isAllValid(pwd)){
			logger.info("Email["+email+"]正在登...");
			User user = userService.findUser(email, pwd);
			if(user != null){
				session.setAttribute(SessionKeys.USER_ID, user.getId());
				session.setAttribute(SessionKeys.USER_PHONE_VERIFY, user.getPhone());
			}else {
				errorCode = ErrorCodes.INVALID_LOGIN;
			}
		}else{
			errorCode = ErrorCodes.INVALID_PARAM;
		}
		
		retMap.put("errorCode",errorCode);
		return retMap;
	}

}
