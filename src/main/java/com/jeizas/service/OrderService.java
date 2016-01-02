package com.jeizas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeizas.dao.OrderDao;
import com.jeizas.entity.Order;
import com.jeizas.utils.BaseService;

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
}
