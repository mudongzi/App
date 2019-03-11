package com.app.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 后台实体
* @Title: BackendUser 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
public class BackendUser implements Serializable {
	
	  /** serialVersionUID*/  
	private static final long serialVersionUID = 1L;
	  private Integer id;			//主键id
	  private String userCode;		//用户编码
	  private String userName;		//用户名称
	  private String userPassword;	//用户密码
	  private Integer userType;		//用户角色类型
	  private Integer createdBy;	//创建者
	  private Date creationDate;	//创建时间
	  private Integer modifyBy;		//更新者
	  private Date modifyDate;		//更新时间
	  private String userTypeName;	//用户角色类型名称
	  
	  
		public BackendUser() {
			super();
		}
		@Override
		public String toString() {
			return "BackendUser [id=" + id + ", userCode=" + userCode + ", userName=" + userName + ", userPassword="
					+ userPassword + ", userType=" + userType + ", createdBy=" + createdBy + ", creationDate="
					+ creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + ", userTypeName="
					+ userTypeName + "]";
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUserCode() {
			return userCode;
		}
		public void setUserCode(String userCode) {
			this.userCode = userCode;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public Integer getUserType() {
			return userType;
		}
		public void setUserType(Integer userType) {
			this.userType = userType;
		}
		public Integer getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(Integer createdBy) {
			this.createdBy = createdBy;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		public Integer getModifyBy() {
			return modifyBy;
		}
		public void setModifyBy(Integer modifyBy) {
			this.modifyBy = modifyBy;
		}
		public Date getModifyDate() {
			return modifyDate;
		}
		public void setModifyDate(Date modifyDate) {
			this.modifyDate = modifyDate;
		}
		public String getUserTypeName() {
			return userTypeName;
		}
		public void setUserTypeName(String userTypeName) {
			this.userTypeName = userTypeName;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		  
}
