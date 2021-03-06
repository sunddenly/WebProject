package com.netctoss.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.netctoss.util.PrivilegeReader;

public class Role {
	private Integer role_id;
	private String name;
	//追加关联属性，用于存储相关联的role_module表
	private List<RoleModule> modules = new ArrayList<>();
	//追加属性用于存储权限id
	private List<Integer> priIds;
	
	public List<Integer> getPriIds() {
		return priIds;
	}

	public void setPriIds(List<Integer> priIds) {
		this.priIds = priIds;
	}

	//追加方法，根据modules权限ID信息返回权限名
	public String getModulesName(){
		String name = "";
		String names = "";
		int i = 0;
		for (RoleModule module : modules) {
			Integer module_id = module.getModule_id();
			name = PrivilegeReader.getPrivilegeNameById(module_id+"");
			names += (i==0)?name:"、"+name;
			i++;
		}
		return names;
	}
	
	public List<RoleModule> getModules() {
		return modules;
	}
	public void setModules(List<RoleModule> modules) {
		this.modules = modules;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {//15233371801
		this.name = name;
	}
	
}
