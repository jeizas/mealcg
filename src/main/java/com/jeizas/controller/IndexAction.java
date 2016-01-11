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

import com.jeizas.dto.FoodDTO;
import com.jeizas.entity.Food;
import com.jeizas.entity.User;
import com.jeizas.service.FoodService;
import com.jeizas.service.OrderService;
import com.jeizas.service.UserService;
import com.jeizas.utils.Constants;
import com.jeizas.utils.ErrorCodes;
import com.jeizas.utils.SessionKeys;

@Controller
public class IndexAction implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexAction.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private OrderService orderService;
	
	/**
	 * 默认页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("pageType", "index");
		return "index";
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		User user = userService.findRecordByProperty("id", 1);
		logger.info(user.getAddr());
		return "index";
	}
	
	/**
	 * 首页数据
	 * @return
	 */
	@RequestMapping(value="/hotfd",method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> hotfood(HttpSession session){
		List<Food> list = foodService.findAllRecords();
		List<FoodDTO> retDTO = new ArrayList<FoodDTO>();
		Integer usrId = (Integer) session.getAttribute(SessionKeys.USER_ID);
		for(Food f:list){
			if(f.getDeleted() == 0){
				FoodDTO dto = new FoodDTO(f);
				if(orderService.isCart(usrId, f.getId())){
					dto.setIsCart("disabled");
				}else{
					dto.setIsCart("");
				}
				retDTO.add(dto);
			}
		}
 		Map<String, Object> retMap = new HashMap<String, Object>();
		Integer errorCode = ErrorCodes.SUCCESS;
		retMap.put("errorCode", errorCode);
		retMap.put("list", retDTO);
		return retMap;
	}
}
