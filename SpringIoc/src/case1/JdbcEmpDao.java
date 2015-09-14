package case1;

public class JdbcEmpDao implements EmpDao{

	public void save() {
		System.out.println("保存数据");
	}

	public void findById() {
		System.out.println("按Id查找记录");
	}

	public void findAll() {
		System.out.println("查找全部记录");
	}
	
}
