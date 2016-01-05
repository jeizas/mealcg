package com.jeizas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeizas.entity.Food;
import com.jeizas.entity.User;
import com.jeizas.service.FoodService;
import com.jeizas.service.UserService;
import com.jeizas.utils.ErrorCodes;

@Controller
public class IndexAction implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexAction.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		List<Food> list = foodService.findAllRecords();
		List<List<Food>> foods = new ArrayList<List<Food>>();
		List<Food> food = new ArrayList<Food>();
		for(int i=0;i<list.size();i++){
			food.add(list.get(i));
			if(i%2 == 1){
				foods.add(food);
				food = new ArrayList<Food>();
			}
		}
		model.addAttribute("foods", foods);
		return "index";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		User user = userService.findRecordByProperty("id", 1);
		logger.info(user.getAddr());
		return "index";
	}
	
	@RequestMapping(value="/hotfd",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> hotfood(){
		List<Food> list = foodService.findAllRecords();
		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer errorCode = ErrorCodes.SUCCESS;
		retMap.put("errorCode", errorCode);
		retMap.put("list", list);
		return retMap;
	}
}
