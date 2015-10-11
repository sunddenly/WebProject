package com.hebut.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.CostDao;

public class TestCostDao {
	public static void main(String[] args) {
		String conf = "applicationContext1.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		CostDao costDao = ac.getBean("jdbcCostDao",CostDao.class);
		costDao.add();
		costDao.delete();
		costDao.update();
		costDao.find();
	}
}
