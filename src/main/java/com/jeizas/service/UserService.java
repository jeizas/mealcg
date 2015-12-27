package com.jeizas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeizas.dao.UserDao;
import com.jeizas.entity.User;
import com.jeizas.utils.BaseService;

@Service("userService")
public class UserService extends BaseService<User>{
	
	@Autowired
	public void setDao(UserDao userDao) {
		super.setDao(userDao);
	}
	public UserDao getDao() {
		return (UserDao)super.getDao();
	}
	
	public User findUser(String email, String pwd, Integer type){
		return getDao().findUser(email, pwd, type);
	}

}
