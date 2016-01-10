package com.jeizas.dao;

import java.util.List;

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
	
	public List<Order> findSubmitOrder(Integer usrId, Integer state){
		String hql = "from Order o where o.foodId in (select f.id from Food f where f.busId=?) and o.state=? and o.deleted=?";
		Query q = createQuery(hql);
		q.setParameter(0, usrId);
		q.setParameter(1, state);
		q.setParameter(2, Constants.DELETED_NO);
		return q.list();
	}
	public void deletedOrderByFoodId(Integer foodId){
		String hql = "update Order set deleted=? where foodId=? ";
		Query q = createQuery(hql);
		q.setParameter(0, Constants.DELETED_YES);
		q.setParameter(1, foodId);
		q.executeUpdate();
	}
	
	public void updateState(Integer usrId){
		String hql = "update Order set state=? where usrId=? ";
		Query q = createQuery(hql);
		q.setParameter(0, Order.STATE_DEF);
		q.setParameter(1, usrId);
		q.executeUpdate();
	}
	public List<Order> cartOrder(Integer usrId){
		String hql = "from Order where usrId=? and state=? and deleted=?";
		Query q = createQuery(hql);
		q.setParameter(0, usrId);
		q.setParameter(1, Order.STATE_SUB);
		q.setParameter(2, Constants.DELETED_NO);
		return q.list();
	}
	public List<Order> selectOrderByUserId(Integer usrId){
		String hql = "from Order where usrId=? and state in (0,1,2,3) and deleted=? order by id desc";
		Query q = createQuery(hql);
		q.setParameter(0, usrId);
		q.setParameter(1, Constants.DELETED_NO);
		return q.list();
	}
	public boolean isCart(Integer usrId, Integer foodId){
		String hql = "from Order where usrId=? and foodId=? and state=? and deleted=?";
		Query q = createQuery(hql);
		q.setParameter(0, usrId);
		q.setParameter(1, foodId);
		q.setParameter(2, 4);
		q.setParameter(3, Constants.NO);
		if(q.list() != null && q.list().size() > 0){
			return true;
		} else{
			return false;
		}
		
	}
}
