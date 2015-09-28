package com.netctoss.dao;

import java.util.List;

import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.util.MyBatisDao;

@MyBatisDao
public interface CostMapperDao {
	public List<Cost> findAll();
	public void deleteCost(int cost_id);
	public void addCost(Cost cost);
	public Cost findById(int id);
	public void updateCost(Cost cost);
	public void startFee(int id);
	public List<Cost> findPage(Page page);
	public int findRows();
}
