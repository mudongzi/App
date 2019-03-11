package com.app.mapper;
/**
 * app版本的基本信息
* @Title: AppVersionMapper 
* @Description:   
* @author xudong  
* @date 2019年1月19日
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.app.pojo.AppInfo;
import com.app.pojo.AppVersion;

public interface AppVersionMapper {
	/**
	 * 查找历史版本信息
	 * @Title: selectAllVersionById  
	 * @Description:   
	 * @param id
	 * @return
	 */
	@SelectProvider(type=com.app.mapper.AppVersionDynaSql.class,method=("selectAppVersion"))
	List<AppVersion> selectAllVersionById(int id);
	/**
	 * 添加版本信息
	 * @Title: insertAppVersion  
	 * @Description:   
	 * @param appVersion
	 * @return
	 */
	@InsertProvider(type=com.app.mapper.AppVersionDynaSql.class,method=("insertAppVersion")) 
	Integer insertAppVersion (AppVersion appVersion); 
	/**
	 * 查询软件所有的版本信息
	 * @Title: findAllVersion  
	 * @Description:   
	 * @return
	 */
	@Select("select * from   app_version order by id desc")
	List<AppVersion> findAllVersion();
	/**
	 * 根据id查询版本信息
	 * @Title: findAppVersion  
	 * @Description:   
	 * @param id
	 * @return
	 */
	@Select("select * from app_version where id=#{id} ")
	AppVersion selectAppVersion(Integer id);
	/**
	 * 更新版本信息通过id与app ID
	 * @Title: updateAppVersion  
	 * @Description:   
	 * @param appVersion
	 * @return
	 */
	@UpdateProvider(type=com.app.mapper.AppVersionDynaSql.class,method="updateAppVersion")
	int updateAppVersion(AppVersion appVersion);
	/**
	 * 删除app版本信息
	 * @Title: deleteAppVersion  
	 * @Description:   
	 * @param appid
	 * @return
	 */
	@Delete("delete from app_version where appId = #{appId}")
	int deleteAppVersion(Integer appid);
}
