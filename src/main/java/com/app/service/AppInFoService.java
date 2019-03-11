package com.app.service;

import java.util.List;

import com.app.pojo.AppInfo;
import com.app.pojo.PageBean;
import com.app.pojo.PageBeanExp;

public interface AppInFoService {
	/**
	 * 按照条件查询所有的AppInfo
	 * @Title: findAllListAppInfo  
	 * @Description:   
	 * @param appInfo
	 * @return
	 */
	public List<AppInfo> findAllListAppInfo(AppInfo appInfo);
	/**
	 * 根据aPKName查询
	 * @Title: findAppInFoByInfo  
	 * @Description:   
	 * @param aPKName
	 * @return
	 */
	public AppInfo findAppInFoByInfo(String aPKName);
	/**
	 * 添加appInFO信息
	 * @Title: addAppIFo  
	 * @Description:   
	 * @param appInfo
	 * @return
	 */
	public int addAppIFo(AppInfo appInfo); 
	/**
	 * 根据id查询app信息
	 * @Title: findOneAppInFoById  
	 * @Description:   
	 * @param id
	 * @return
	 */
	AppInfo findOneAppInFoById(Integer id);
	/**
	 * 更新app基本信息
	 * @Title: modifyAppInfo  
	 * @Description:   
	 * @param appInfo
	 * @return
	 */
	int modifyAppInfo(AppInfo appInfo);
	/**
	 * 删除app信息
	 * @Title: removeAppInFo  
	 * @Description:   
	 * @param id
	 * @return
	 */
	int removeAppInFo(Integer id);
	/**
	 * 查找appInFo分页
	 * @Title: findAllAppInfoByLimit  
	 * @Description:   
	 * @param pageBeanExp
	 * @return
	 */
	 PageBean<AppInfo> findAllAppInfoByLimit(int pageNo);
}
