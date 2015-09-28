package com.netctoss.entity;

import java.sql.Date;

public class AdminInfo {
	private Integer admin_id;
	private String admin_code;
	private String password;
	private String name;
	private String telephone;
	private String email;
	private Date enrolldate;
	//扩展属性：接收提交的验证码信息
	private String code;
	
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
