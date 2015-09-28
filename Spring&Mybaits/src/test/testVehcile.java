package test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hebut.dao.DeptMapperDao;
import com.hebut.dao.VehicleMapperDao;
import com.hebut.entity.Car;
import com.hebut.entity.Dept;
import com.hebut.entity.Emp;
import com.hebut.entity.Truck;
import com.hebut.entity.Vehicle;

public class testVehcile {
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		
		VehicleMapperDao dao = ac.getBean("vehicleMapperDao",VehicleMapperDao.class);
		List<Vehicle> list = dao.findAll();
		for (Vehicle vehicle : list) {
			if(vehicle instanceof Truck){
				System.out.println("¿¨³µ"+vehicle.getName());
			}else if(vehicle instanceof Car){
				System.out.println("Æû³µ"+vehicle.getName());
			}
		}
		
	}
}
