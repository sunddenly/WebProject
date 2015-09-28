package com.hebut.dao;

import java.util.List;

import com.hebut.annotation.MybatisDao;
import com.hebut.entity.Dept;

@MybatisDao
public interface DeptMapperDao {
	public List<Dept> findAll();
	public List<Dept> findAll1();
	public Dept findById(int id);
	public Dept findById1(int id);
}
