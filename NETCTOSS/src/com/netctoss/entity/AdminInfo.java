package com.netctoss.entity;

import java.sql.Date;
import java.util.List;

public class AdminInfo {
	private Integer admin_id;
	private String admin_code;
	private String password;
	private String name;
	private String telephone;
	private String email;
	private Date enrolldate;
	//追加属性，用于存取角色
	private List<Role> roles;
	//追加属性，用于存储角色role_id
	private List<Integer> roleIds;
	//扩展属性：接收提交的验证码信息
	private String code;
	
	
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	public String getRoleNames(){
		String names="";
		for(int i=0;i<roles.size();i++){
			Role r = roles.get(i);
			names += r.getName();
			if(i<roles.size()-1){
				names += "、";
			}
		}
		return names;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public AdminInfo() {
		super();
	}
	public AdminInfo(Integer admin_id, String admin_code, String password,
			String name, String telephone, String email, Date enrolldate) {
		super();
		this.admin_id = admin_id;
		this.admin_code = admin_code;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.enrolldate = enrolldate;
	}
	
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_code() {
		return admin_code;
	}
	public void setAdmin_code(String admin_code) {
		this.admin_code = admin_code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	} 
	
}
