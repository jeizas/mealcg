package com.jeizas.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jeizas.entity.Food;
import com.jeizas.entity.User;
import com.jeizas.utils.BaseHibernateDao;
import com.jeizas.utils.Constants;

@Repository
public class FoodDao extends BaseHibernateDao<Food>{
	
	public Food findNofinishRecord(Integer usrId){
		String hql = " from Food where busId=? and name is null and deleted=?";
		Query q = createQuery(hql);
		q.setParameter(0, usrId);
		q.setParameter(1, Constants.DELETED_NO);
		List<Food> list = q.list();
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

}
