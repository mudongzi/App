package com.app.service;

import java.util.List;

import com.app.pojo.DevUser;

public interface DevUserService {
	/**
	 * 测试：查询所有的开发人员
	 * @Title: selectAllDevUser  
	 * @Description:   
	 * @return
	 */
	public List<DevUser> selectAllDevUser();
	/**
	 * 添加用户
	 * @Title: addDevUser  
	 * @Description:   
	 * @param devUser
	 * @return
	 */
	public int addDevUser(DevUser devUser);
	/**
	 * 开发者用户登录
	 * @Title: selectDevUser  
	 * @Description:   
	 * @param devUser
	 * @return
	 */
	public DevUser selectDevUser(DevUser devUser);
}
