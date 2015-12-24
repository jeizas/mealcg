package com.jeizas.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jeizas.entity.User;
import com.jeizas.utils.BaseHibernateDao;
import com.jeizas.utils.Constants;

@Repository
public class UserDao extends BaseHibernateDao<User>{
	
	public User findUser(String email, String pwd){
		String hql = " from User where email=? and pwd=? and deleted=?";
		Query q = createQuery(hql);
		q.setParameter(0, email);
		q.setParameter(1, pwd);
		q.setParameter(2, Constants.DELETED_NO);
		List<User> list = q.list();
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

}
