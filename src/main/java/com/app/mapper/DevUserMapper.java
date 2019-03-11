package com.app.mapper;
/**
 * 开发人员接口
* @Title: DevUserMapper 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.app.pojo.DevUser;

public interface DevUserMapper {
		/**
		 * 
		 * @Title: findAll  
		 * @Description:   
		 * @return
		 */
		@Select("select * from dev_user")
		public List<DevUser> findAll();
		/**
		 * 
		 * @Title: insertDevUser  
		 * @Description:   
		 * @param devUser
		 * @return
		 */
		@InsertProvider(type=DevUserDynaSqlProvider.class ,method="insertSql")
		public  int insertDevUser(DevUser devUser);
		/**
		 * 登录接口
		 * @Title: getDevUser  
		 * @Description:   
		 * @return
		 */
		@SelectProvider(type=DevUserDynaSqlProvider.class,method="selectDevUser")
		public DevUser getDevUser(DevUser devUser);
	}
