package com.jeizas.controller;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeizas.entity.User;
import com.jeizas.service.UserService;

@Controller
public class IndexAction implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexAction.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		User user = userService.findRecordByProperty("id", 1);
		logger.info(user.getAddr());
		return "index";
	}
}
