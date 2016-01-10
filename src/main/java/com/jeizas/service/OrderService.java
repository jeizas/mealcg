package com.jeizas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeizas.dao.OrderDao;
import com.jeizas.entity.Order;
import com.jeizas.utils.BaseService;
import com.jeizas.utils.ErrorCodes;

@Service("orderService")
public class OrderService extends BaseService<Order>{
	
	@Autowired
	public void setDao(OrderDao orderDao) {
		super.setDao(orderDao);
	}
	public OrderDao getDao() {
		return (OrderDao)super.getDao();
	}

	public Order updateCount(Integer usrId, Integer Id){
		return getDao().updateCount(usrId, Id);
	}
	
	public List<Order> findSubmitOrder(Integer usrId, Integer state){
		return getDao().findSubmitOrder(usrId, state);
	}
	public void deletedOrderByFoodId(Integer foodId){
		getDao().deletedOrderByFoodId(foodId);
	}
	
	public void subCart(Integer usrId){
		getDao().updateState(usrId);
	}
	public List<Order> cartOrder(Integer usrId){
		return getDao().cartOrder(usrId);
	}
	public List<Order> selectOrderByUserId(Integer usrId){
		return getDao().selectOrderByUserId(usrId);
	}
	public boolean isCart(Integer usrId, Integer foodId){
		return getDao().isCart(usrId, foodId);
	}
}
