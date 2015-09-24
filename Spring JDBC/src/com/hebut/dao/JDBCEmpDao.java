package com.hebut.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.hebut.entity.Emp;
import com.hebut.entity.EmpMapper;

public class JDBCEmpDao extends JdbcDaoSupport implements EmpDao{

	public void save(Emp emp) {
		String sql = "INSERT INTO emp_ VALUES(?,?,?,?,?,?,?,?)";
		Object[] params = {
				emp.getEmpno(),
				emp.getEname(),
				emp.getJob(),
				emp.getMgr(),
				emp.getHiredate(),
				emp.getSal(),
				emp.getComm(),
				emp.getDeptno(),
		};
		super.getJdbcTemplate().update(sql,params);
	}

	public Emp findById(int empno) {
		String sql = "SELECT * FROM emp_ WHERE empno=?";
		
		Object[] param = {empno};
		EmpMapper mapper = new EmpMapper();
		//返回一行结果使用QueryForObject
		Emp emp = (Emp)super.getJdbcTemplate().queryForObject(sql, param,mapper);
		return emp;
	}

	public List<Emp> findAll() {
		//返回多行记录
		String sql = "SELECT * FROM emp_";
		EmpMapper mapper = new EmpMapper();
		List<Emp> listEmp = super.getJdbcTemplate().query(sql,mapper);
		return listEmp;
	}
}
