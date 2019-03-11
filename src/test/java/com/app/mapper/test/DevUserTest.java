package com.app.mapper.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.mapper.DevUserMapper;
import com.app.pojo.DevUser;

/**
 * 
* @Title: DevUserTest 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
public class DevUserTest {
	@Test
	public void testFindAllUser() {
		@SuppressWarnings("resource")
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		DevUserMapper devUserMapper = factory.getBean(DevUserMapper.class);
		List<DevUser> list = devUserMapper.findAll();
		for (DevUser devUser : list) {
			System.out.println(devUser);
		}
	}
}
