package com.app.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 广告推广
* @Title: Promotion 
* @Description:   
* @author xudong  
* @date 2019年1月16日
 */
public class AdPromotion implements Serializable {
	/** serialVersionUID*/  
	private static final long serialVersionUID = 1L;
	private Integer id;				//主键id
	private Integer appId;				//appId（来源于：app_info表的主键id）
	private String adPicPath;		//广告图片存储路径
	private Integer adPV;				//广告点击量
	private Integer carouselPosition;	//轮播位（1-n）
	private Date startTime;			//起效时间
	private Date endTime;			//失效时间
	private  Integer createdBy;		//创建者
	private Date creationDate;		//创建时间
	private Integer modifyBy;			//更新者
	private Date modifyDate;		//最新更新时间
	
	public AdPromotion(Integer id, Integer appId, String adPicPath, Integer adPV, int carouselPosition, Date startTime,
			Date endTime, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.appId = appId;
		this.adPicPath = adPicPath;
		this.adPV = adPV;
		this.carouselPosition = carouselPosition;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	public AdPromotion() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAdPicPath() {
		return adPicPath;
	}

	public void setAdPicPath(String adPicPath) {
		this.adPicPath = adPicPath;
	}

	public Integer getAdPV() {
		return adPV;
	}

	public void setAdPV(Integer adPV) {
		this.adPV = adPV;
	}

	public Integer getCarouselPosition() {
		return carouselPosition;
	}

	public void setCarouselPosition(Integer carouselPosition) {
		this.carouselPosition = carouselPosition;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AdPromotion [id=" + id + ", appId=" + appId + ", adPicPath=" + adPicPath + ", adPV=" + adPV
				+ ", carouselPosition=" + carouselPosition + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}
	
	
	
	}
