package com.netctoss.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netctoss.dao.AdminInfoMapperDao;
import com.netctoss.dao.CostMapperDao;
import com.netctoss.entity.AdminInfo;
import com.netctoss.entity.AdminRole;
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
		//findCondition(dao);
		//findRow(dao);
		//findName(dao);
		//addAdmin(dao);
		//addAdminRole(dao);
		//findRow(dao);
		resetPwd(dao);
	}
	private static void findCondition(AdminInfoMapperDao dao){
		AdminInfoPage page = new AdminInfoPage();
		page.setModuleId(-1);
		page.setRoleName("*");
		page.setPage(1);
		List<AdminInfo> list = dao.findByCondition(page);
		System.out.println(list.size());
		for (AdminInfo adminInfo : list) {
			System.out.println(adminInfo.getAdmin_code());
			String rolename="";
			for(Role r:adminInfo.getRoles()){
				rolename +=r.getName()+",";
			}
			System.out.println(adminInfo.getAdmin_code()+" "+rolename);
		}
	}
	private static void findRow(AdminInfoMapperDao dao){
		AdminInfoPage page = new AdminInfoPage();
		page.setModuleId(-1);
		page.setRoleName("*");
		int num= dao.findRows(page);
		System.out.println(num);
	}
	private static void resetPwd(AdminInfoMapperDao dao){
		List<Integer> list = new ArrayList<>();
		list.add(7006);
		dao.resetPwd(list);
	}
	private static void addAdmin(AdminInfoMapperDao dao){
		AdminInfo info = new AdminInfo();
		info.setAdmin_code("sun1");
		info.setName("lunxun");
		info.setPassword("123");
		info.setEmail("luxun@163.com");
		info.setTelephone("12812678765");
		dao.addAdmin(info);
		System.out.println(info.getAdmin_id());
	}
	private static void addAdminRole(AdminInfoMapperDao dao){
		AdminRole role = new AdminRole();
		role.setAdmin_id(3000);
		role.setRole_id(100);
		dao.addAdminRole(role);
	}
	private static void findAdmin(AdminInfoMapperDao dao) {
		AdminInfo info = new AdminInfo();
		info.setAdmin_code("admin");
		info.setPassword("123");
		AdminInfo admin = dao.findByAdminCodeAndPwd(info);
		System.out.println(info.getAdmin_code());
	}
	private static void findName(AdminInfoMapperDao dao) {
		String name="admin";
		AdminInfo admin = dao.findByName(name);
		System.out.println(admin.getName()+admin.getPassword()+admin.getRoleNames());
	}
}
