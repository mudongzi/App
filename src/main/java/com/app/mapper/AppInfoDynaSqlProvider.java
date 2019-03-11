package com.app.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.app.pojo.AppInfo;
import com.app.pojo.DevUser;
import com.app.pojo.PageBeanExp;

/**
 * app信息动态sql
* @Title: AppInfoDynaSqlProvider 
* @Description:   
* @author xudong  
* @date 2019年1月17日
 */
public class AppInfoDynaSqlProvider {
	
		public String selectWhitParamSql(AppInfo appInfo) {
			return new SQL() {
				{
					SELECT("*");
					FROM("app_info");
					if(appInfo.getStatus()!=null) {
						WHERE("status=#{status}");
					}
					if(appInfo.getFlatformId()!=null) {
						WHERE("flatformId=#{flatformId} ");
					}
					if(appInfo.getCategoryLevel1()!=null) {
						WHERE("categoryLevel1=#{categoryLevel1} ");
					}
					if(appInfo.getCategoryLevel2()!=null) {
						WHERE("categoryLevel2=#{categoryLevel2} ");
					}
					if(appInfo.getCategoryLevel3()!=null) {
						WHERE("categoryLevel3=#{categoryLevel3}");
					}
					if(appInfo.getSoftwareName()!=null) {
						WHERE("softwareName like \"%\"#{softwareName}\"%\" ");
					}
				}
			}.toString();
		}
		
		private final String SQL = "a.id, a.softwareName,a.APKName,a.supportROM,a.softwareSize,a.devId,(select devName from dev_user where id = a.devId) as devName,"
				+ " a.status,(select valueName from data_dictionary d where  a.status=d.valueId AND d.typeCode='APP_STATUS') as statusName,"
				+ "	a.flatformId,(select valueName from data_dictionary d where  a.flatformId=d.valueId AND d.typeCode='APP_FLATFORM') as flatformName,"
				+ "	a.categoryLevel1,(select categoryName from app_category c where  c.id=a.categoryLevel1) as categoryLevel1Name,"
				+ "	a.categoryLevel2,(select categoryName from app_category c where  c.id=a.categoryLevel2) as categoryLevel2Name,"
				+ "	a.categoryLevel3,(select categoryName from app_category c where  c.id=a.categoryLevel3) as categoryLevel3Name,a.downloads, a.onSaleDate, a.versionId,"
				+ "	(select v.versionNo from app_version v where v.id=a.versionId ) as versionNo";
/**
 * 查询app详细信息
 * @Title: selectCreateAppInfoSQL  
 * @Description:   
 * @param appInfo
 * @return
 */
		public String selectCreateAppInfoSQL(AppInfo appInfo) {
			return new SQL() {
				{
					SELECT(SQL);
					FROM("app_info AS a");
					if (appInfo.getSoftwareName() != null) {
						WHERE("softwareName LIKE CONCAT('%',#{softwareName},'%')");
					}
					if (appInfo.getCategoryLevel1() != null && appInfo.getCategoryLevel1() > 0) {
						WHERE("categoryLevel1=#{categoryLevel1}");
					}
					if (appInfo.getCategoryLevel2() != null && appInfo.getCategoryLevel2() > 0) {
						WHERE("categoryLevel2=#{categoryLevel2}");
					}
					if (appInfo.getCategoryLevel3() != null && appInfo.getCategoryLevel3() > 0) {
						WHERE("categoryLevel3=#{categoryLevel3}");
					}
					if (appInfo.getStatus() != null && appInfo.getStatus() > 0) {
						WHERE("status=#{status}");
					}
					if (appInfo.getFlatformId() != null && appInfo.getFlatformId() > 0) {
						WHERE("flatformId=#{flatformId}");
					}
					if(appInfo.getCreationDate() !=null) {
						ORDER_BY("creationDate =#{CreationDate}") ;
					}
					 
				}
			}.toString();
		}

		/**
		 * 分页
		 * @Title: selectCreateAppInfoSQL1  
		 * @Description:   
		 * @param appInfo
		 * @return
		 */
		
		public String selectCreateAppInfoSQL1(PageBeanExp pageBeanExp) {
			return new SQL() {
				{
					SELECT(SQL);
					FROM("app_info AS a");
					if (pageBeanExp.getAppInfo().getSoftwareName() != null) {
						WHERE("softwareName LIKE CONCAT('%',#{softwareName},'%')");
					}
					if (pageBeanExp.getAppInfo().getCategoryLevel1() != null && pageBeanExp.getAppInfo().getCategoryLevel1() > 0) {
						WHERE("categoryLevel1=#{categoryLevel1}");
					}
					if (pageBeanExp.getAppInfo().getCategoryLevel2() != null && pageBeanExp.getAppInfo().getCategoryLevel2() > 0) {
						WHERE("categoryLevel2=#{categoryLevel2}");
					}
					if (pageBeanExp.getAppInfo().getCategoryLevel3() != null && pageBeanExp.getAppInfo().getCategoryLevel3() > 0) {
						WHERE("categoryLevel3=#{categoryLevel3}");
					}
					if (pageBeanExp.getAppInfo().getStatus() != null && pageBeanExp.getAppInfo().getStatus() > 0) {
						WHERE("status=#{status}");
					}
					if (pageBeanExp.getAppInfo().getFlatformId() != null && pageBeanExp.getAppInfo().getFlatformId() > 0) {
						WHERE("flatformId=#{flatformId}");
					}
					if(pageBeanExp.getAppInfo().getCreationDate() !=null) {
						ORDER_BY("creationDate =#{CreationDate}") ;
					}
				}
			}.toString()+" LIMIT pageBeanExp.startSize={#startSize},pageBeanExp.size={#size}";
		}
	/**
	 * 更新Appinfo 的基本信息根据appinfo ID修改射入修改者信息
	 * @Title: upDateDevUser  
	 * @Description:  if(appInfor.getAPKName() != null) {
				 SET("aPKName=#{aPKName}");
			 }  
	 * @param devUser
	 * @return
	 */
	public String upDateAppInfo(AppInfo appInfor) {
		
		return new SQL()
			{
			 {
				UPDATE("app_info");
			 if(appInfor.getAppInfo() != null) {
				 SET("appInfo=#{appInfo}");
			 }
			 if(appInfor.getCategoryLevel1() != null) {
				 SET("categoryLevel1=#{categoryLevel1}");
			 }
			 if(appInfor.getCategoryLevel1Name() != null) {
				 SET("categoryLevel1Name=#{categoryLevel1Name}");
			 }
			 if(appInfor.getCategoryLevel2Name() != null) {
				SET("categoryLevel2Name=#{categoryLevel2Name}"); 
			 }
			 if(appInfor.getCategoryLevel3() != null) {
				 SET("categoryLevel3=#{categoryLevel3}");
			 }
			 if(appInfor.getCategoryLevel3Name() != null) {
				 SET("categoryLevel3Name=#{categoryLevel3Name}"); 
			 }
			 if(appInfor.getCreatedBy() != null) {
				 SET("createdBy=#{createdBy}");
			 }
			 if(appInfor.getCreationDate() != null) {
				 SET("creationDate=#{creationDate}");
			 }
			 if(appInfor.getDevId() != null) {
				 SET("devId=#{devId}");
			 }
			 if(appInfor.getDevName() != null) {
				 SET("devName=#{devName}");
			 }
			 if(appInfor.getDownloads() != null) {
				 SET("downloads=#{downloads}");
			 }
			 if(appInfor.getFlatformId() != null) {
				 SET("flatformId=#{flatformId}");
			 }
			 if(appInfor.getFlatformName() != null) {
				 SET("flatformName=#{flatformName}");
			 }
			 if(appInfor.getInterfaceLanguage() != null) {
				 SET("interfaceLanguage=#{interfaceLanguage}");
			 }
			 if(appInfor.getLogoLocPath() != null) {
				 SET("logoLocPath=#{logoLocPath}");
			 }
			 if(appInfor.getLogoPicPath() !=null) {
				 SET("logoPicPath=#{logoPicPath}");
			 }
			 if(appInfor.getModifyBy() != null) {
				 SET("modifyBy=#{modifyBy}");
			 }
			 if(appInfor.getModifyDate() != null) {
				 SET("modifyDate=#{modifyDate}");
			 }
			 if(appInfor.getOffSaleDate() !=null) {
				 SET("offSaleDate=#{offSaleDate}");
			 }
			 if(appInfor.getOnSaleDate() != null) {
				 SET("onSaleDate=#{onSaleDate}");
			 }
			 if(appInfor.getSoftwareName() != null) {
				 SET("softwareName=#{softwareName}");
			 }
			 if(appInfor.getSoftwareSize() !=null) {
				 SET("softwareSize=#{softwareSize}");
			 }
			 if(appInfor.getStatus() != null) {
				 SET("status=#{status}");
			 }
			 /* if(appInfor.getStatusName() != null) {
				 SET("statusName=#{statusName}");
			 }*/
			 if(appInfor.getSupportROM() != null) {
				 SET("supportROM=#{supportROM}");
			 }
			 if(appInfor.getUpdateDate() != null) {
				 SET("updateDate=#{updateDate}");
			 }
			 if(appInfor.getVersionId() != null) {
				 SET("versionId=#{versionId}");
			 }
			 if(appInfor.getVersionNo() != null) {
				 SET("versionNo=#{versionNo}");
			 }
			 if(appInfor.getId() != null) {
				 WHERE("id=#{id}");
			 }
			 }	
			}	
				.toString();
	}
	
	public String upDateAppinFo_version(AppInfo appInfor) {
		
		return new SQL()
			{
			{
				UPDATE("app_info");
				 if(appInfor.getVersionId() != null) {
					 SET("versionId=#{versionId}");
				 }
				 if(appInfor.getId() != null) {
					 WHERE("id=#{id}");
				 }
			}
			}	
				.toString();
	}
}
