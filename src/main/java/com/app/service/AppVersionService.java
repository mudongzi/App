package com.app.service;

import java.util.List;

import com.app.pojo.AppInfo;
import com.app.pojo.AppVersion;

public interface AppVersionService {
	/**
	 * 
	 * @Title: findAllAppVersionById  
	 * @Description:   
	 * @param id
	 * @return
	 */
	List<AppVersion> findAllAppVersionById(int id);
	/**
	 * 添加版本信息
	 * @Title: addAppVersion  
	 * @Description:   
	 * @param appVersion
	 * @return
	 */
	Integer addAppVersion(AppVersion appVersion);
	/**
	 * 查询版本同过id
	 * @Title: findAppVersionById  
	 * @Description:   
	 * @param id
	 * @return
	 */
	AppVersion findAppVersionById(Integer id);
	/**
	 * 修改app版本信息
	 * @Title: modityAppVersion  
	 * @Description:   
	 * @param appVersion
	 * @return
	 */
	int modityAppVersion(AppVersion appVersion);
}
