package com.app.mapper.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.mapper.AppCategoryMapper;
import com.app.pojo.AppCategory;

/**
 * 
* @Title: AppCategoryMapperTest 
* @Description:   
* @author xudong  
* @date 2019年1月17日
 */
public class AppCategoryMapperTest {
	
	@Test
	public void testGetListAppCategory() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		AppCategoryMapper categoryMapper = applicationContext.getBean(AppCategoryMapper.class);
		List<AppCategory> listAppCategory = categoryMapper.selectListAppCategory(null);
		for (AppCategory appCategory2 : listAppCategory) {
			System.out.println(appCategory2);
		}
	}
	
	@Test
	public void testGetListAppCategory2() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		AppCategoryMapper categoryMapper = applicationContext.getBean(AppCategoryMapper.class);
		List<AppCategory> listAppCategory = categoryMapper.getListAppCategoryById(0);
		for (AppCategory appCategory2 : listAppCategory) {
			System.out.println(appCategory2);
		}
	}
}
