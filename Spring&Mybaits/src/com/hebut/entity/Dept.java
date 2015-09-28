package com.hebut.entity;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable{
	private Integer deptno;
	private String dname;
	private String loc;
	//追加关联属性，用于获取相关的Emp对象
	private List<Emp> emps;
	
	
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
