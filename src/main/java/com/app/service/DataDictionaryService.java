package com.app.service;

import java.util.List;

import com.app.pojo.DataDictionary;

public interface DataDictionaryService {
	/**
	 * 根据类型编码来查询状态或所属平台
	 * @Title: getListDataDictionary  
	 * @Description:   
	 * @param dataDictionary
	 * @return
	 */
	public List<DataDictionary> getListDataDictionary(String typeCode);
}
