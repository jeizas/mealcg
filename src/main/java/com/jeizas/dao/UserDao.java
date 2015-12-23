package com.jeizas.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jeizas.entity.User;
import com.jeizas.utils.BaseHibernateDao;
import com.jeizas.utils.Constants;

@Repository
public class UserDao extends BaseHibernateDao<User>{
	
	public User findUser(String email, String pwd){
		String hql = " from User where email=? and password=? and deleted=?";
		Query q = createQuery(hql);
		q.setParameter(0, email);
		q.setParameter(1, pwd);
		q.setParameter(2, Constants.DELETED_NO);
		return (User) q.list().get(0);
	}

}
