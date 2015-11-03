package com.netctoss.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.netctoss.entity.Service;
import com.netctoss.entity.vo.ServiceLine;
import com.netctoss.entity.vo.ServicePage;

public class TestServiceDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		ServiceMapperDao dao = ac.getBean("serviceMapperDao",ServiceMapperDao.class);
		//listService(dao);
		//findCostName(dao);
//		validateUsername(dao);
		Service service = new Service();
		service.setAccount_id(1011);
		service.setUnix_host("192.168.0.29");
		service.setOs_username("luwsh");
		service.setLogin_passwd("123");
		service.setCost_id(1);
		dao.addService(service);
	}
	private static void validateUsername(ServiceMapperDao dao) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("unixHost","192.168.0.20");
		map.put("osUsername","luwsh");
		String str = dao.validateOsusername(map);
		System.out.println(str);
	}
	private static void findCostName(ServiceMapperDao dao) {
		List<Cost> list = dao.findCostName();
		for (Cost cost : list) {
			System.out.println(cost.getCost_id()+","+cost.getName());
		}
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
