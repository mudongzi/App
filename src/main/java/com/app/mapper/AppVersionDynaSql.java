package com.app.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.app.pojo.AppVersion;

public class AppVersionDynaSql {
	/**
	 */
	private final String SQL1 = "(select softwareName from app_info a where a.id = b.appId) as appName,"
			+"b.versionNo,b.versionSize,"
			+"(select valueName from data_dictionary d where d.valueId = b.publishStatus AND d.typeCode='PUBLISH_STATUS') as publishStatusName,"
			+"b.downloadLink,b.modifyDate";
	public String selectAppVersion(Integer appId) {
		return new SQL() {
			{
				SELECT(SQL1);
				FROM("app_version b");
				if(appId!=0) {
					WHERE("appId=#{appId}");
				}
			}
			
		}.toString();
	}
	
	public String insertAppVersion(AppVersion appVersion) {
		return new SQL() {
			{
				INSERT_INTO("app_version");
				if(appVersion.getAppId()!=null) {
					VALUES("appId","#{appId}");
				}
				if(appVersion.getVersionNo()!=null) {
					VALUES("versionNo","#{versionNo}");
				}
				if(appVersion.getVersionInfo()!=null) {
					VALUES("versionInfo","#{versionInfo}");
				}
				if(appVersion.getPublishStatus()!=null) {
					VALUES("publishStatus","#{publishStatus}");
				}
				if(appVersion.getDownloadLink()!=null) {
					VALUES("downloadLink","#{downloadLink}");
				}
				if(appVersion.getVersionSize()!=null) {
					VALUES("versionSize","#{versionSize}");
				}
				if(appVersion.getCreatedBy()!=null) {
					VALUES("createdBy","#{createdBy}");
				}
				if(appVersion.getCreationDate()!=null) {
					VALUES("creationDate","#{creationDate}");
				}
				if(appVersion.getModifyBy()!=null) {
					VALUES("modifyBy","#{modifyBy}");
				}
				if(appVersion.getModifyDate()!=null) {
					VALUES("modifyDate","#{modifyDate}");
				}
				if(appVersion.getApkLocPath()!=null) {
					VALUES("apkLocPath","#{apkLocPath}");
				}
				if(appVersion.getApkFileName()!=null) {
					VALUES("apkFileName","#{apkFileName}");
				}
			}
		}.toString();
	}
	
	public String updateAppVersion(AppVersion appVersion) {
		return new SQL() {
			{
				UPDATE("app_version");
				if(appVersion.getVersionNo()!=null) {
					SET("versionNo=#{versionNo}");
				}
				if(appVersion.getVersionSize()!=null) {
					SET("versionSize=#{versionSize}");
				}
				if(appVersion.getVersionInfo()!=null) {
					SET("versionInfo=#{versionInfo}");
				}
				if(appVersion.getModifyDate()!=null) {
					SET("modifyDate=#{modifyDate}");
				}
				WHERE("id=#{id} AND appId=#{appId}");
			}
		}.toString();
	}
}
