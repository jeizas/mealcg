package com.jeizas.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jeizas.entity.Order;
import com.jeizas.utils.BaseHibernateDao;
import com.jeizas.utils.Constants;

@Repository
public class OrderDao extends BaseHibernateDao<Order>{
	
	public Order updateCount(Integer usrId, Integer foodId){
		String hql = "from Order where usrId=? and id=? and isPay=? and deleted=?";
		Query q = createQuery(hql);
		q.setParameter(0, usrId);
		q.setParameter(1, foodId);
		q.setParameter(2, Constants.NO);
		q.setParameter(3, Constants.DELETED_NO);
		if(q.list().isEmpty()){
			return null;
		}else{
			return (Order) q.list().get(0);
		}
	}
}
