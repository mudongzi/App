package com.app.service.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.service.AppInFoService;

public class AppInForServiceTest {

	@Test
	public void testFindAllUser1() {
		@SuppressWarnings("resource")
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	AppInFoService appInFoService = factory.getBean(AppInFoService.class);
	appInFoService.removeAppInFo(74);
	}
}
