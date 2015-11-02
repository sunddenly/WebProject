package com.netctoss.entity.vo;

import com.netctoss.entity.Page;

public class AdminInfoPage extends Page{
	private Integer moduleId;
	private String roleName;
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
