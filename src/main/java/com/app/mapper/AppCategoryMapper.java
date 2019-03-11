package com.app.mapper;
/**
 * 
* @Title: AppCategoryMapper 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.app.pojo.AppCategory;

public interface AppCategoryMapper {
	/**
	 * 根据用户操作显示相应二级三级分类，页面做异步请求
	 * @Title: getListAppCategory  
	 * @Description:   
	 * @param appCategory
	 * @return
	 */
	@SelectProvider(type =com.app.mapper.AppCategoryDynaSqlProvier.class,method="findAppCategoryById")
	public List<AppCategory> getListAppCategoryById(Integer  id);
	/**
	 * 
	 * @Title: selectListAppCategory  
	 * @Description:  显示一级分类内容 
	 * @param pId
	 * @return
	 */
	@SelectProvider(type =com.app.mapper.AppCategoryDynaSqlProvier.class,method="findAppCategory")
	public List<AppCategory> selectListAppCategory(Integer  pId);

}
