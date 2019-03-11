package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.mapper.DevUserMapper;
import com.app.pojo.DevUser;
import com.app.service.DevUserService;
@Service("devUserService")
@Transactional
public class DevUserServiceImpl implements DevUserService {
	@Autowired
	private DevUserMapper devUserMapper;
	
	@Override
	public List<DevUser> selectAllDevUser() {
		// TODO Auto-generated method stub
		return devUserMapper.findAll();
	}

	@Override
	public int addDevUser(DevUser devUser) {
		int num =0;
		try {
			num = devUserMapper.insertDevUser(devUser);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("事物异常回滚");
		}
		return num;
	}

	@Override
	public DevUser selectDevUser(DevUser devUser) {
		DevUser devUser1 = devUserMapper.getDevUser(devUser);
		return devUser1;
	}
	

}
