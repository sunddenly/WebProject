package com.hebut.dao;

import java.util.List;

import com.hebut.entity.Emp;

public interface EmpDao {
	public void save(Emp emp);
	public Emp findById(int empno);
	public List<Emp> findAll();
	
}
