package com.app.pojo;

import java.util.List;

public class PageBean<T> {
	private int pageNo;// 当前页码数
	private int pageLength;// 总页码数
	private int pageSize;// 每页显示的记录数
	private int dataSize;// 总记录数
	private List<T> listData;// 总记录数

	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", pageLength=" + pageLength + ", pageSize=" + pageSize + ", dataSize="
				+ dataSize + ", listData=" + listData + "]";
	}

	public PageBean(int pageSize) {
		this.pageNo = 1;
		this.pageLength = 1;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
			return;
		} else if (pageNo > pageLength) {
			this.pageNo = this.pageLength;
			return;
		} else {
			this.pageNo = pageNo;
			return;
		}
	}

	public int getPageLength() {
		return pageLength;
	}

	public void setPageLength(int dataSize) {
		if (dataSize % pageSize == 0) {
			this.pageLength = dataSize / this.pageSize;
		} else {
			this.pageLength = dataSize / this.pageSize + 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}
}