package com.app.mapper;

import org.apache.ibatis.jdbc.SQL;

import com.app.pojo.DevUser;

/**
 * 开发人员动态sql
* @Title: DevUserDynaSqlProvider 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
public class DevUserDynaSqlProvider {
	public String selectDevUser(DevUser devUser) {
		return new SQL()
		{
			{
			 SELECT ("*");
			 FROM ("dev_user");
			 if(devUser.getId() !=null) {
				 WHERE("id=#{id}");
			 }
			 if(devUser.getCreatedBy() != null) {
				 WHERE("createdBy=#{createdBy}");
			 }
			 if(devUser.getCreationDate() != null) {
				 WHERE("creationDate=#{creationDate}");
			 }
			 if(devUser.getDevCode() !=null) {
				 WHERE("devCode=#{devCode}");
			 }
			 if(devUser.getDevEmail() != null) {
				 WHERE("devEmail=#{devEmail}");
			 }
			 if(devUser.getDevInfo() != null) {
				 WHERE("devInfo=#{devInfo}");
			 }
			 if(devUser.getDevName() != null) {
				 WHERE("devName like\"%\" #{devName}\"%\"");
			 }
			 if(devUser.getDevPassword() != null) {
				 WHERE("devPassword=#{devPassword}");
			 }
			 if(devUser.getModifyBy() != null) {
				 WHERE("modifyBy=#{modifyBy}");
			 }
			 if(devUser.getModifyDate() !=null) {
				 WHERE("modifyDate=#{modifyDate}");
			 }
			}
		}	
			.toString();
	}
	/**
	 * 添加开发人员
	 * @Title: insertSql  
	 * @Description:   
	 * @return
	 */
	public String insertSql(DevUser devUser) {
		return new SQL()
		{
			{
			 INSERT_INTO("dev_user"); 	
			 if(devUser.getId() != null) {
				VALUES("id","#{id}"); 
			 }
			 if(devUser.getCreatedBy() !=null) {
				 VALUES("createdBy","#{createdBy}");
			 }
			 if(devUser.getCreationDate() != null) {
				 VALUES("creationDate","#{creationDate}");
			 }
			 if(devUser.getDevCode() !=null) {
				 VALUES("devCode","#{devCode}");
			 }
			 if(devUser.getDevEmail() !=null) {
				 VALUES("devEmail","#{devEmail}");
			 }
			 if(devUser.getDevInfo() !=null) {
				 VALUES("devInfo","#{devInfo}");
			 }
			 if(devUser.getDevName() != null) {
				 VALUES("devName","#{devName}");
			 }
			 if(devUser.getDevPassword() !=null) {
				 VALUES("devPassword","#{devPassword}");
			 }
			 if(devUser.getModifyBy() != null ) {
				 VALUES("modifyBy","#{modifyBy}");
			 }
			 if(devUser.getModifyDate() != null) {
				 VALUES("modifyDate","#{modifyDate}");
			 }
			}
			
		}	
		.toString();
	}
	/**
	 * 更新开发者信息
	 * @Title: upDateDevUser  
	 * @Description:   
	 * @param devUser
	 * @return
	 */
/*	public String upDateDevUser(DevUser devUser) {
		
		return new SQL()
			{
			 {
				UPDATE("dev_user");
			 if(devUser.getCreatedBy() != null) {
				 SET("createdBy=#{createdBy}");
			 }
			 if(devUser.getCreationDate() != null) {
				 SET("creationDate=#{creationDate}");
			 }
			 if(devUser.getDevCode() != null) {
				 SET("devCode=#{devCode}");
			 }
			 if(devUser.getDevEmail() != null) {
				 SET("devEmail=#{devEmail}");
			 }
			 if(devUser.getDevInfo() != null) {
				SET("devInfo=#{devInfo}"); 
			 }
			 if(devUser.getDevName() != null) {
				 SET("devName=#{devName}");
			 }
			 if(devUser.getDevPassword() != null) {
				 SET("devPassword=#{devPassword}"); 
			 }
			 if(devUser.getModifyBy() != null) {
				 SET("modifyBy=#{modifyBy}");
			 }
			 if(devUser.getModifyDate() != null) {
				 SET("modifyDate=#{modifyDate}");
			 }
			 if(devUser.getId() != null) {
				 WHERE("id=#{id}");
			 }
			 }	
			}	
				.toString();
	}*/
}
