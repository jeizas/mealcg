package com.jeizas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeizas.dao.BaseDAO;
import com.jeizas.entity.User;
import com.jeizas.utils.BaseService;

@Service("userService")
public class UserService extends BaseService<User>{
	
	private BaseDAO<User> userDao;
	
	public User findUser(String email, String pwd){
		String sql = "from User where email='"+email+"' ";
		return userDao.get(User.class, 1);
	}

}
