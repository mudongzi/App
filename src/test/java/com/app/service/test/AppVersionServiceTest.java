package com.app.service.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojo.AppVersion;
import com.app.service.AppVersionService;
public class AppVersionServiceTest {

	@Test
	public void testFindAllUser() {
		@SuppressWarnings("resource")
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		AppVersionService appVersionService = factory.getBean(AppVersionService.class);
		AppVersion appVersion = new AppVersion();
		appVersion.setAppId(48);
		appVersion.setVersionNo("11");
		//appVersion.set
		appVersionService.addAppVersion(appVersion );
	}
	@Test
	public void testFindAllUser1() {
		@SuppressWarnings("resource")
		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		AppVersionService appVersionService = factory.getBean(AppVersionService.class);
		AppVersion appVersion = new AppVersion();
		appVersion.setId(53);
		appVersion.setAppId(48);
		appVersion.setModifyDate(new Date());
		appVersionService.modityAppVersion(appVersion);
	}
	
}
