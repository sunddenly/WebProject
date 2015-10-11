package com.hebut.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface CostDao {
	public void find();
	public void add();
	public void delete();
	public void update();
}
