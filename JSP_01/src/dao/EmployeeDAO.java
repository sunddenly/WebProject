package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

/**
 * 员工信息的数据操作类
 * @author hdoop
 * 实现员工信息的增删该查
 */
public class EmployeeDAO {
	/**
	 * 增加员工信息
	 * @throws Exception 
	 */
	public void save(Employee emp) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO t_emp VALUES(null,?,?,?)");
			pstmt.setString(1, emp.getName());
			pstmt.setDouble(2, emp.getSalary());
			pstmt.setInt(3, emp.getAge());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	/**
	 * 查询全部员工信息
	 * @throws Exception 
	 */
	public List<Employee> findAll() throws Exception{
		List<Employee> emps = new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM t_emp");
			res = pstmt.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String name = res.getString("name");
				double salary = res.getDouble("salary");
				int age = res.getInt("age");
				Employee emp = new Employee(id, name, salary, age);
				emps.add(emp);
			}
			return emps;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(conn != null){
				conn.close();
			}
		}
	}
}
