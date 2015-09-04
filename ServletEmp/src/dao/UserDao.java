package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;

/**
 * 用户信息操作类
 * @author hdoop
 *
 */
public class UserDao {
	public User findByUserName(String username) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		User user = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM t_user WHERE username=?");
			pstmt.setString(1, username);
			res = pstmt.executeQuery();
			if(res.next()){
				int id = res.getInt("id");
				String pwd = res.getString("pwd");
				String name = res.getString("name");
				String gender = res.getString("gender");
				user = new User(id, username, pwd, name, gender);
			}
			return user;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(conn != null){
				DBUtil.closeConnection(conn);
			}
		}
	}
	/**
	 * 保存实体信息到数据库
	 * @param user
	 * @throws Exception
	 */
	public void save(User user) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO t_user VALUES(null,?,?,?,?)");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getGender());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(conn != null){
				DBUtil.closeConnection(conn);
			}
		}
	}
	public static void main(String[] args) {
		User user = new User("Ketty", "123", "Catalina", "女");
		UserDao dao = new UserDao();
		try {
			User username = dao.findByUserName(user.getUsername());
			System.out.println(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
