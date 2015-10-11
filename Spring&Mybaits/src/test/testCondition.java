package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.DeptMapperDao;
import com.hebut.dao.EmpMapperDao;
import com.hebut.entity.Dept;
import com.hebut.entity.Emp;

public class testCondition {
	public static void main(String[] args) {
		
		String conf = "applicationContext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		EmpMapperDao dao = ac.getBean("empMapperDao",EmpMapperDao.class);
		Emp emp = new Emp();
//		Dept dept = new Dept();
//		dept.setDeptno(10);
//		emp.setDept(dept);
//		List<Emp> list = dao.findByDeptNo(emp);
//		emp.setSal(1000.0);
//		List<Emp> list = dao.findBySal(emp);
//		List<Emp> list = dao.findBySalAndDeptno(emp);
//		emp.setEmpno(7782);
//		emp.setSal(1000.0);
//		emp.setEname("tom");
//		dao.updateEmp(emp);
		emp.setDeptnos(new Integer[]{10});
		List<Emp> list = dao.findByDeptNos(emp);
		for (Emp e : list) {
			System.out.println(e.getEmpno()+","+e.getEname()+","+e.getSal());
		}
	}
}
