package com.netctoss.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;

public class TestAdminDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		AdminInfoMapperDao dao = ac.getBean("adminInfoMapperDao",AdminInfoMapperDao.class);
		AdminInfo info = new AdminInfo();
		info.setAdmin_code("admin");
		info.setPassword("123");
		AdminInfo admin = dao.findByAdminCodeAndPwd(info);
		System.out.println(info.getAdmin_code());
	}
}
