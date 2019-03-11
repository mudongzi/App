package com.app.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 开发人员表
* @Title: DevUser 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
public class DevUser implements Serializable {
	  /** serialVersionUID*/  
	  private static final long serialVersionUID = 1L;
	  private Integer id;			//主键ID
	  private String devCode;		//开发者账号
	  private String devName;		//开发者名称
	  private String devPassword;	//开发者密码
	  private String devEmail;		//开发者邮箱
	  private String devInfo;		//开发者简介
	  private Integer createdBy;	//创建者
	  private Date creationDate;	//创建日期
	  private Integer modifyBy;		//更新者
	  private Date modifyDate;		//更新日期
	public DevUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevPassword() {
		return devPassword;
	}
	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}
	public String getDevEmail() {
		return devEmail;
	}
	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}
	public String getDevInfo() {
		return devInfo;
	}
	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
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
	public DevUser(Integer id, String devCode, String devName, String devPassword, String devEmail, String devInfo,
			Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.devCode = devCode;
		this.devName = devName;
		this.devPassword = devPassword;
		this.devEmail = devEmail;
		this.devInfo = devInfo;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "DevUser [id=" + id + ", devCode=" + devCode + ", devName=" + devName + ", devPassword=" + devPassword
				+ ", devEmail=" + devEmail + ", devInfo=" + devInfo + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	  
}
