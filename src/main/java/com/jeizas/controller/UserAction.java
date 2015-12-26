package com.jeizas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserAction {
	
	/**
	 * 用户个人中心
	 * @return
	 */
	@RequestMapping(value="/uhome",method=RequestMethod.GET)
	public String home(){
		return "homeu";
	}

	/**
	 * 我的订单
	 * @return
	 */
	@RequestMapping(value="/uorder",method=RequestMethod.GET)
	public String order(){
		return "orderu";
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
}
