package com.app.mapper;
/**
 * 
* @Title: AppInfoMappper 
* @Description:   appInfo基本类的持久层接口
* @author xudong  
* @date 2019年1月17日
 */

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.app.pojo.AppInfo;
import com.app.pojo.PageBeanExp;

public interface AppInfoMappper {
	/**
	 * 查询App信息基本列表
	 * @Title: findAll  
	 * @Description:   
	 * @return
	 */
	@SelectProvider(type=com.app.mapper.AppInfoDynaSqlProvider.class,method="selectCreateAppInfoSQL" )
	public List<AppInfo> findAll(AppInfo appInfo);
	/**
	 * 更新appInfo信息
	 * @Title: updateAppInfo  
	 * @Description:   
	 * @param appInfo 根据appInfo 的id 必须提供更新者的姓名
	 * @return
	 */
	@UpdateProvider(type=com.app.mapper.AppInfoDynaSqlProvider.class,method="upDateAppInfo")
	public int updateAppInfo(AppInfo appInfo);
	/**
	 * 查询是否有相同的aPKName名称存在
	 * @Title: getAppInFoByAPKName  
	 * @Description:   
	 * @param aPKName
	 * @return
	 */
	@Select("select * from app_info where APKName =#{aPKName}")
	public AppInfo getAppInFoByAPKName(String aPKName);
	
	/**
	 * 
	 * @Title: selectListAppCategory  
	 * @Description:   添加app基本信息
	 * @param pId
	 * @return
	 */
	@Insert("insert into app_info (softwareName,APKName,supportROM,interfaceLanguage,updateDate,softwareSize,\r\n" + 
			"							devId,appInfo,status,onSaleDate,offSaleDate,categoryLevel1,categoryLevel2,\r\n" + 
			"							categoryLevel3,downloads,flatformId,logoPicPath,logoLocPath,createdBy,creationDate)\r\n" + 
			"				values(#{softwareName},#{APKName},#{supportROM},#{interfaceLanguage},#{updateDate},\r\n" + 
			"					   #{softwareSize},#{devId},#{appInfo},#{status},#{onSaleDate},#{offSaleDate},\r\n" + 
			"					   #{categoryLevel1},#{categoryLevel2},#{categoryLevel3},#{downloads},\r\n" + 
			"					   #{flatformId},#{logoPicPath},#{logoLocPath},#{createdBy},#{creationDate})")
	int insertAppInFo(AppInfo appInfo);
	/**
	 * 根据app ID查询APP信息
	 * @Title: getAppInFoByid  
	 * @Description:   
	 * @param id
	 * @return
	 */
	@Select("select * from app_info where id=#{id}")
	AppInfo getAppInFoByid(Integer id);
	/**
	 * 更新appInfo中的版本信息
	 * @Title: updateAppInFoVersionId  
	 * @Description:   
	 * @param appInfo
	 * @return
	 */
	@UpdateProvider(type = com.app.mapper.AppInfoDynaSqlProvider.class,method="upDateAppinFo_version")
	Integer updateAppInFoVersionId(AppInfo appInfo);
	/**
	 * 删除app通过id
	 * @Title: deleteAppInFo  
	 * @Description:   
	 * @param id
	 * @return
	 */
	@Delete("delete from app_info where id = #{id}")
	int deleteAppInFo(Integer id);
	
	@SelectProvider(type=com.app.mapper.AppInfoDynaSqlProvider.class,method="selectCreateAppInfoSQL1" )
	public List<AppInfo> findListAppInFo(PageBeanExp pageBeanExp);
}
