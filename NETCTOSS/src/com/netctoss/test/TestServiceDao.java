package com.netctoss.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.dao.RoleMapperDao;
import com.netctoss.dao.ServiceMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.entity.Role;
import com.netctoss.entity.RoleModule;
import com.netctoss.entity.vo.ServiceLine;
import com.netctoss.entity.vo.ServicePage;

public class TestServiceDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ServiceMapperDao dao = ac.getBean("serviceMapperDao",ServiceMapperDao.class);
		listService(dao);
		
	}
	private static void listService(ServiceMapperDao dao) {
		ServicePage page = new ServicePage();
		page.setIdcard_no("*");
		page.setStatus("-1");
		page.setOs_username("*");
		page.setUnix_host("*");
		List<ServiceLine> list = dao.findByCondition(page);
		System.out.println(list.size());
		for (ServiceLine line : list) {
			System.out.println(line.getCost_name()+" "+line.getIdcard_no()+line.getCost_descr());
		}
	}
}
