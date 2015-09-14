package com.some.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {
	private DataSource ds;

	public DataSource getDs() {
		return ds;
	}
	@Autowired
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
}
