package com.app.mapper;
/**
 * 
* @Title: DataDictionaryMapper 
* @Description:   
* @author xudong  
* @date 2019年1月17日
 */

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.app.pojo.DataDictionary;

public interface DataDictionaryMapper {
	/**
	 * 根据类型编码查询
	 * @Title: getDataDictionary  
	 * @Description:   
	 * @param dataDictionary
	 * @return
	 */
	@Select("select * from data_dictionary where typeCode=#{typeCode}")
	public List<DataDictionary> getDataDictionary(String typeCode); 
}
