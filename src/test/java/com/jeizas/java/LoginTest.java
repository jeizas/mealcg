package com.jeizas.java;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jeizas.entity.User;
import com.jeizas.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/springmvc.xml","classpath*:/applicationContext.xml"})
public class LoginTest {
	
	private static Logger logger = Logger.getLogger(LoginTest.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testIndexs() throws Exception{
		User user = userService.findUser("jeizas","67c3538b882b557b3ff9ec72bd6f1ab6",1); // .findRecordByProperty("id", 1);
		logger.info(user);
	}

}
