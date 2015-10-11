package com.hebut.entity;

import java.io.Serializable;
import java.sql.Date;


public class Emp implements Serializable{
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hiredate;
	private Double sal;
	private Double comm;
	private Integer deptno;
	//追加一个部门的关联属性
	private Dept dept = new Dept();
	//追加一个属性，存储多个部门编号
	private Integer[] deptnos;
	public Integer[] getDeptnos() {
		return deptnos;
	}

	public void setDeptnos(Integer[] deptnos) {
		this.deptnos = deptnos;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empno, String ename, String job, Integer mgr,
			Date hiredate, Double sal, Double comm, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public Integer getEmpno() {
		return empno;
	}
	
	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public double getComm() {
		return comm;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal=" + sal
				+ ", comm=" + comm + ", deptno=" + deptno + "]";
	}
	
}
