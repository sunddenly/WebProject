package com.hebut.dao;

import java.util.List;

import com.hebut.annotation.MybatisDao;
import com.hebut.entity.Emp;
@MybatisDao
public interface EmpMapperDao {
	public List<Emp> findAll();
	public void deleteEmp(int id);
	public void updateEmp(Emp emp);
	public Emp findById(int id);
	public Emp findById1(int id);
	public List<Emp> findByDeptNo(Emp emp);
	public List<Emp> findBySal(Emp emp);
	public List<Emp> findBySalAndDeptno(Emp emp);
	public List<Emp> findByDeptNos(Emp emp);
}
