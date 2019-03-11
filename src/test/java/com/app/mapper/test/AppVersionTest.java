package com.app.mapper.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.mapper.AppInfoMappper;
import com.app.pojo.AppInfo;

public class AppVersionTest {

	@Test
	public void testAppInFoAppCategory() {
			
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		AppInfoMappper categoryMapper = applicationContext.getBean(AppInfoMappper.class);
		AppInfo appInfo = new AppInfo();
		appInfo.setId(75);
		appInfo.setVersionId(48);
		int list = categoryMapper.updateAppInFoVersionId(appInfo);
		System.out.println(list);
	
	}
}
