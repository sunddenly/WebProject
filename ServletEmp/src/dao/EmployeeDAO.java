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
	
	/**
	 * 删除员工信息
	 * @param id
	 * @throws Exception
	 */
	public void delete(int id)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM t_emp WHERE id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(conn != null){
				conn.close();
			}
		}
	}
	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public Employee findById(int id) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		Employee emp = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM t_emp WHERE id=?");
			pstmt.setInt(1, id);
			res = pstmt.executeQuery();
			if(res.next()){
				String name = res.getString("name");
				double salary = res.getDouble("salary");
				int age = res.getInt("age");
				emp = new Employee(id, name, salary, age);
			}
			return emp;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(conn != null){
				conn.close();
			}
		}
	}
	/**
	 * 修改员工信息
	 * @param emp
	 * @throws Exception
	 */
	public void modify(Employee emp)throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE t_emp set name=?,salary=?,age=? WHERE id=?");
			pstmt.setString(1, emp.getName());
			pstmt.setDouble(2, emp.getSalary());
			pstmt.setInt(3, emp.getAge());
			pstmt.setInt(4, emp.getId());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
