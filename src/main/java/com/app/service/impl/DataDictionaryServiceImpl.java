package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.mapper.DataDictionaryMapper;
import com.app.pojo.DataDictionary;
import com.app.service.DataDictionaryService;

@Service
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Autowired
	private DataDictionaryMapper dataDictionaryMapper;
	@Override
	public List<DataDictionary> getListDataDictionary(String typeCode) {
		List<DataDictionary> dictionaryList = dataDictionaryMapper.getDataDictionary(typeCode);
		return dictionaryList;
	}

}
