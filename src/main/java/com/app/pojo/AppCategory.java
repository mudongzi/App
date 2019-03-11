package com.app.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * APP种类/分类
* @Title: AppCategory 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
public class AppCategory implements Serializable {
	  /** serialVersionUID*/  
	  private static final long serialVersionUID = 1L;
	  private Integer id;			//主键
	  private String categoryCode;	//分类编码
	  private String categoryName;	//分类名称
	  private Integer parentId;		//父级节点
	  private Integer createdBy;	//创建者
	  private Date creationDate;	//创建时间
	  private Integer modifyBy;		//更新者
	  private Date modifyDate;		//最新更新时间
	  
	  
	public AppCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppCategory(Integer id, String categoryCode, String categoryName, Integer parentId, Integer createdBy,
			Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "AppCategory [id=" + id + ", categoryCode=" + categoryCode + ", categoryName=" + categoryName
				+ ", parentId=" + parentId + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		if(parentId == null) {
			this.parentId = 0;
		}
		this.parentId = parentId;
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
	  
}
