package com.app.mapper.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.mapper.AppInfoMappper;
import com.app.pojo.AppInfo;

public class AppInFoMapperTest {
	private static final AppInfo AppInfo = null;

	@Test
	public void testAppInFoAppCategory() {
				@SuppressWarnings("resource")
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		AppInfoMappper categoryMapper = applicationContext.getBean(AppInfoMappper.class);
		
		List<AppInfo> list = categoryMapper.findAll(AppInfo);
		for (AppInfo appInfo : list) {
			System.out.println(appInfo);
		}
	
	}
}
