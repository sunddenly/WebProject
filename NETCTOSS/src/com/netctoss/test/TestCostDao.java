package com.netctoss.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.Cost;

public class TestCostDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		CostMapperDao dao = ac.getBean("costMapperDao",CostMapperDao.class);
		List<Cost> list = dao.findAll();
		System.out.println(list);
	}
}
