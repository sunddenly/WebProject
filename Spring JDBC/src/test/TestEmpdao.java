package test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.EmpDao;
import com.hebut.entity.Emp;

public class TestEmpdao {
	@Test
	public void testSave(){
		String conf = "/applicationContext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		EmpDao dao = ac.getBean("jdbcEmpdao",EmpDao.class);
		
//		Emp emp = new Emp(101, "Jboss", "testing", 1, Date.valueOf("2015-9-22"), 5000.0, 300.0, 10);
//		dao.save(emp);
		
//		Emp emp = dao.findById(101);
//		System.out.println(emp.getEname());
		List<Emp> list = dao.findAll();
		System.out.println(list);
	}
}
