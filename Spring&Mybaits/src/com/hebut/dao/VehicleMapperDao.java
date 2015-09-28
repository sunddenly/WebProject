package com.hebut.dao;

import java.util.List;

import com.hebut.annotation.MybatisDao;
import com.hebut.entity.Vehicle;

@MybatisDao
public interface VehicleMapperDao {
	public List<Vehicle> findAll();
}
