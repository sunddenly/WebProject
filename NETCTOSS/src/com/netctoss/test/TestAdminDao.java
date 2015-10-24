package com.netctoss.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.entity.Role;
import com.netctoss.entity.vo.AdminInfoPage;

public class TestAdminDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		AdminInfoMapperDao dao = ac.getBean("adminInfoMapperDao",AdminInfoMapperDao.class);
		//findAdmin(dao);
		findCondition(dao);
	}
	private static void findCondition(AdminInfoMapperDao dao){
		AdminInfoPage page = new AdminInfoPage();
		page.setModuleId(-1);
		page.setRoleName("*");
		List<AdminInfo> list = dao.findByCondition(page);
		for (AdminInfo adminInfo : list) {
			System.out.println(adminInfo.getAdmin_code());
			String rolename="";
			for(Role r:adminInfo.getRoles()){
				rolename +=r.getName()+",";
			}
			System.out.println(adminInfo.getAdmin_code()+" "+rolename);
		}
	}
	private static void findAdmin(AdminInfoMapperDao dao) {
		AdminInfo info = new AdminInfo();
		info.setAdmin_code("admin");
		info.setPassword("123");
		AdminInfo admin = dao.findByAdminCodeAndPwd(info);
		System.out.println(info.getAdmin_code());
	}
}
