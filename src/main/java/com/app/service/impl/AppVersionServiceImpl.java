package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.mapper.AppInfoMappper;
import com.app.mapper.AppVersionMapper;
import com.app.pojo.AppInfo;
import com.app.pojo.AppVersion;
import com.app.service.AppVersionService;

@Service
@Transactional
public class AppVersionServiceImpl implements AppVersionService {

	@Autowired
	private AppVersionMapper appVersionMapper;
	@Autowired
	private AppInfoMappper appInfoMappper;
	@Override
	public List<AppVersion> findAllAppVersionById(int id) {
		List<AppVersion> listAppVersion = appVersionMapper.selectAllVersionById(id);
		return listAppVersion;
	}

	@Override
	public Integer addAppVersion(AppVersion appVersion) {
		
		int num =0;
		try {
			int num2 = appVersionMapper.insertAppVersion(appVersion);
			List<AppVersion> allVersion = appVersionMapper.findAllVersion();
			System.out.println(""+allVersion.get(0).getId());
			AppInfo appInfo = new AppInfo();
			appInfo.setVersionId(allVersion.get(0).getId());
			appInfo.setId(appVersion.getAppId());
			System.out.println(appInfo);
			Integer num1 = appInfoMappper.updateAppInFoVersionId(appInfo);
			if(num2>0&&num1>0) {
				num = 1;
			}
		} catch (Exception e) {
			throw new RuntimeException("添加版本失败");
		}
		
		return num;
	}

	@Override
	public AppVersion findAppVersionById(Integer id) {
		AppVersion appVersion = appVersionMapper.selectAppVersion(id);
		return appVersion;
	}

	@Override
	public int modityAppVersion(AppVersion appVersion) {
		int num =0;
		try {
			 num = appVersionMapper.updateAppVersion(appVersion);
			//int i = 1/0;
		} catch (Exception e) {
			throw new RuntimeException("事物原唱");
		}
		
		return num;
	}

}
