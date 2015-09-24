package com.hebut.dao;

import java.util.List;

import com.hebut.annotation.MybatisDao;
import com.hebut.entity.Emp;
@MybatisDao
public interface EmpMapperDao {
	public List<Emp> findAll();
}
