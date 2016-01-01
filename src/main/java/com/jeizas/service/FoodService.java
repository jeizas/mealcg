package com.jeizas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeizas.dao.FoodDao;
import com.jeizas.entity.Food;
import com.jeizas.utils.BaseService;

@Service("foodService")
public class FoodService extends BaseService<Food>{
	
	@Autowired
	public void setDao(FoodDao foodDao) {
		super.setDao(foodDao);
	}
	public FoodDao getDao() {
		return (FoodDao)super.getDao();
	}
	
	
	public Food findNofinishRecord(Integer usrId){
		return getDao().findNofinishRecord(usrId);
	}
}
