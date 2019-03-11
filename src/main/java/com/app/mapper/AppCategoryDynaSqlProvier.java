package com.app.mapper;
/**
 * 三级分类动态sql
* @Title: AppCategoryDynaSqlProvier 
* @Description:   
* @author xudong  
* @date 2019年1月17日
 */

import org.apache.ibatis.jdbc.SQL;

import com.app.pojo.AppCategory;

public class AppCategoryDynaSqlProvier {
	//SELECT * FROM `app_category` where app_category.parentId in  (SELECT id FROM `app_category` where app_category.parentId=(SELECT app_category.id FROM `app_category` where app_category.id=1));

	public String findAppCategory(Integer parentId ){
		return new SQL() {
			{
				SELECT ("*"); 
				FROM ("app_category");
				if(parentId != null) {
					WHERE("parentId=#{parentId}");
				}
				
				if(parentId == null) {
					WHERE("parentId is null");
				}
			}
		
	}
				.toString();
	}
	
	
	public String findAppCategoryById(Integer id ){
		
		return new SQL() {
			{
				SELECT ("*"); 
				FROM ("app_category");
				if(id == null) {
					WHERE("parentId is null");	
				}
				if(id != null) {
					WHERE("parentId=#{id}");
				}
				
			}
			
		}
					.toString();
		}
}
