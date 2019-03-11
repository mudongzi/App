package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.mapper.AppInfoMappper;
import com.app.mapper.AppVersionMapper;
import com.app.pojo.AppInfo;
import com.app.pojo.AppVersion;
import com.app.pojo.PageBean;
import com.app.pojo.PageBeanExp;
import com.app.service.AppInFoService;

@Service
@Transactional
public class AppInFoServiceImpl implements AppInFoService {
	@Autowired
	private AppInfoMappper appInFoMapper;
	@Autowired
	private AppVersionMapper appVersionMapper;
	@Override
	public List<AppInfo> findAllListAppInfo(AppInfo appInfo) {
		List<AppInfo> findAll = appInFoMapper.findAll(appInfo);
		return findAll;
	}
	@Override
	public AppInfo findAppInFoByInfo(String aPKName) {
		AppInfo appInfo = appInFoMapper.getAppInFoByAPKName(aPKName);
		return appInfo;
	}
	@Override
	public int addAppIFo(AppInfo appInfo) {
		int num = appInFoMapper.insertAppInFo(appInfo);
		return num;
	}
	@Override
	public AppInfo findOneAppInFoById(Integer id) {
		AppInfo appInfo = appInFoMapper.getAppInFoByid(id);
		return appInfo;
	}
	@Override
	public int modifyAppInfo(AppInfo appInfo) {
		int num = appInFoMapper.updateAppInfo(appInfo);
		return num;
	}
	@Override
	public int removeAppInFo(Integer id) {
		int num = 0;
		try {
			int num2 = appInFoMapper.deleteAppInFo(id);
			//先查询该app的 所有版本
			List<AppVersion> list = appVersionMapper.selectAllVersionById(id);
			if(list.size() >0 ) {
				int num1 = appVersionMapper.deleteAppVersion(id);
				if(num2 > 0 && num1 > 0){
					num = 1;
				}
			}
			if(num2 >0) {
				num = 1;
			}
		} catch (Exception e) {
			throw new RuntimeException("删除失败");
		}
		return num;
	}
	@Override
	public PageBean<AppInfo> findAllAppInfoByLimit(int pageNo) {
		//查询显示数据的总数
		//int dataSize = appInFoMapper.
		
		return null;
	}
	
	

}
