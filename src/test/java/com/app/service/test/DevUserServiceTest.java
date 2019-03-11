package com.app.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojo.DevUser;
import com.app.service.DevUserService;

public class DevUserServiceTest {
	@Test
	public void testFindAllUser() {
		@SuppressWarnings("resource")
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		DevUserService devUserService = factory.getBean(DevUserService.class);
		List<DevUser> list = devUserService.selectAllDevUser();
		for (DevUser devUser : list) {
			System.out.println(devUser);
		}
	}
	
	@Test
	public void testAddUser() {
		System.out.println("**************");
		@SuppressWarnings("resource")
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		DevUserService devUserService = factory.getBean(DevUserService.class);
		DevUser devUser = new DevUser();
		devUser.setDevName("张三"+Math.rint(1));
		int num = devUserService.addDevUser(devUser);
		System.out.println(num);
	}
}
