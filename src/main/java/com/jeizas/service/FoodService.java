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
	public Food updateFood(Food tmp, Food food){
		tmp.setDsc(food.getDsc());
		tmp.setMoney(food.getMoney());
		tmp.setIsNew(food.getIsNew());
		tmp.setName(food.getName());
		tmp.setPublish(Food.PUBLISH_YES);
		return getDao().update(tmp);
	}
}
