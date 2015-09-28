package com.netctoss.entity;

public class Page {
	//显示第几页数据，默认第一页
	private Integer page = 1;
	//一页默认显示5条
	private Integer pageSize = 5;//成员变量名pageSize
	//最大页数
	private Integer totalPage = 1;
	
	public Page() {
		super();
	}
	public Page(Integer page, Integer pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	//getter属性名begin
	public Integer getBegin(){
		return (page-1)*pageSize;
	}
	//setter属性名begin
	public Integer getPage() {
		return page;
	}
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
