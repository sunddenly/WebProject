package com.hebut.mapper;

import java.util.List;

import com.hebut.entity.Dept;
import com.hebut.entity.myDept;

public interface DeptMapper {
	public Dept findById(int id);
	public List<Dept> findAll();
	public List<myDept> findAll1();
}
