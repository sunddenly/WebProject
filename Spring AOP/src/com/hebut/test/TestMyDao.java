package com.hebut.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.CostDao;
import com.hebut.dao.MyDao;

public class TestMyDao {
	public static void main(String[] args) {
		String conf = "applicationContext1.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		MyDao costDao = ac.getBean("myDao",MyDao.class);
		costDao.find();
		System.out.println(costDao.getClass().getName());
	}
}
