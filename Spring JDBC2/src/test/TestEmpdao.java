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
		EmpDao dao = ac.getBean("jdbcEmpDao1",EmpDao.class);
		
		List<Emp> list = dao.findAll();
		System.out.println(list);
	}
}
