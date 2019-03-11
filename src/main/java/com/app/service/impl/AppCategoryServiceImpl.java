package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.mapper.AppCategoryMapper;
import com.app.pojo.AppCategory;
import com.app.service.AppCategoryService;
@Service
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService{
	@Autowired
	private AppCategoryMapper appCategoryMapper;
	/**
	 * 
	 */
	@Override
	public List<AppCategory> findListAppCategoryById(Integer id) {
		List<AppCategory> listAppCategory = appCategoryMapper.getListAppCategoryById(id);
		return listAppCategory;
	}
	@Override
	public List<AppCategory> findListAppCategory(Integer pId) {
		List<AppCategory> listAppCategoryByPId = appCategoryMapper.selectListAppCategory(pId);
		return listAppCategoryByPId;
	}


	

}
