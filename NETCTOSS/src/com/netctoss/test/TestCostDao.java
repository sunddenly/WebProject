package com.netctoss.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

public class TestCostDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		CostMapperDao dao = ac.getBean("costMapperDao",CostMapperDao.class);
//		Cost cost = new Cost();
//		cost.setName("sun");
//		dao.addCost(cost);
		Cost cost = dao.findByName("5.9ÔªÌ×²Í");
		System.out.println(cost.getName());
	}
}
