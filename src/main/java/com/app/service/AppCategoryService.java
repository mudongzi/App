package com.app.service;

import java.util.List;

import com.app.pojo.AppCategory;
/**
 * 
* @Title: AppCategoryService 
* @Description:   
* @author xudong  
* @date 2019年1月17日
 */
public interface AppCategoryService {

	public List<AppCategory> findListAppCategoryById(Integer id);
	
	public List<AppCategory> findListAppCategory(Integer pId);
	
	
}
