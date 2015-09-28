package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.DeptMapperDao;
import com.hebut.dao.EmpMapperDao;
import com.hebut.entity.Dept;
import com.hebut.entity.Emp;

public class testEmp {
	public static void main(String[] args) {
		
		String conf = "applicationContext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		EmpMapperDao dao = ac.getBean("empMapperDao",EmpMapperDao.class);
//		List<Emp> list = dao.findAll();
//		for (Emp emp : list) {
//			System.out.println(emp.getEmpno()+","+emp.getEname()+","+emp.getJob());
//		}
		Emp emp = dao.findById(7369);
		System.out.println(emp.getDeptno());//ʧЧ
		System.out.println(emp.getEname());
		System.out.println(emp.getDept().getDeptno());
		System.out.println(emp.getDept().getDname());
	}
}
