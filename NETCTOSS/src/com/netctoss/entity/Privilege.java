package com.netctoss.entity;

import java.util.List;
/**
 * ����Privilege.xml�����ʵ����
 * @author jxy
 *
 */
public class Privilege {
	private String id;
	private String name;
	private List<String> urls;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + ", urls=" + urls
				+ "]";
	}
	
}