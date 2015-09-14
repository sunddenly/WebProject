package com.some.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.some.dao.DeptDao;
import com.some.dao.EmpDao;

@Component
public class EmpService {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmpDao empDao;
	public DeptDao getDeptDao() {
		return deptDao;
	}
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	public EmpDao getEmpDao() {
		return empDao;
	}
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
	
}
