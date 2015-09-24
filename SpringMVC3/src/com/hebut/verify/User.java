package com.hebut.verify;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.hebut.annotation.Phone;

public class User {
	@NotEmpty(message="用户名不能为空")
	private String username;
	@NotEmpty(message="密码不能为空")
	@Size(min=6,max=10,message="密码位数必须在{min}-{max}之间")
	private String password;
	@Phone(message="电话号码格式必须是13,15,18开始！")
	private String telePhone;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String telePhone) {
		super();
		this.username = username;
		this.password = password;
		this.telePhone = telePhone;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	
}
