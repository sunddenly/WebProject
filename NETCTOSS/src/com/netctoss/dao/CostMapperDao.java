package com.netctoss.dao;

import java.util.List;

import com.netctoss.entity.Cost;
import com.netctoss.util.MyBatisDao;

@MyBatisDao
public interface CostMapperDao {
	public List<Cost> findAll();
	public void deleteCost(int cost_id);
	public void addCost(Cost cost);
}
