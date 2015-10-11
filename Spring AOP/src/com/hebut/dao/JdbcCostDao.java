package com.hebut.dao;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcCostDao implements CostDao{

	public void find() {
		System.out.println("find");
		String s = null;
		s.length();
	}

	public void add() {
		System.out.println("add");
		
	}

	public void delete() {
		System.out.println("delete");
	}

	public void update() {
		System.out.println("update");
	}

}
