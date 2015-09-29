package com.netctoss.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.dao.RoleMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.Cost;
import com.netctoss.entity.Page;
import com.netctoss.entity.Role;
import com.netctoss.entity.RoleModule;

public class TestRoleDao {
	public static void main(String[] args) {
		String conf = "com/netctoss/config/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		RoleMapperDao dao = ac.getBean("roleMapperDao",RoleMapperDao.class);
		List<Role> list = dao.findPage();
		for (Role role : list) {
			System.out.println(role.getRole_id()+" "+role.getName()+role.getModulesName());
//			System.out.println("È¨ÏÞ£º");
//			for (RoleModule m : role.getModules()) {
//				System.out.println(m.getRole_id()+" "+m.getModule_id());
//			}
		}
	}
}
