package com.jeizas.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexAction implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexAction.class);
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String index(){
		logger.info("啦啦啦");
		return "index";
	}

}
