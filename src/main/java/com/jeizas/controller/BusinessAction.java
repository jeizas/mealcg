package com.jeizas.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BusinessAction implements Serializable{

	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(BusinessAction.class);
	
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
}
