package com.hebut.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Emp>{

	public void processRow(ResultSet arg0) throws SQLException {
		
	}
	//实现记录和Emp映射
	public Emp mapRow(ResultSet arg0, int arg1) throws SQLException {
		Emp emp = new Emp();
		emp.setEmpno(arg0.getInt("empno"));
		emp.setEname(arg0.getString("ename"));
		emp.setJob(arg0.getString("job"));
		emp.setMgr(arg0.getInt("mgr"));
		emp.setHiredate(arg0.getDate("hiredate"));
		emp.setSal(arg0.getDouble("sal"));
		emp.setComm(arg0.getDouble("comm"));
		emp.setDeptno(arg0.getInt("deptno"));
		return emp;
	}

}
