package com.hebut.ioc.constrcutor;

import com.hebut.ioc.setter.JDBCDataSource;

import java.sql.*;

/**
 * Created by jxy on 2016/6/5.
 */
public class MySqlUserDao implements UserDao {
    private JDBCDataSource dataSource;

    //创建MysqlUserDao实例，必须依赖于JDBCDataSource实例
    public MySqlUserDao(JDBCDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findByName(String name) {
        String SQL1 = "SELECT * FROM emp_ WHERE name=?";
        String SQL2 = "SELECT * FROM emp_ ";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL1);
            ps.setString(1, name);
            ResultSet res = ps.executeQuery();

            User user=null;
            while(res.next()){
                user=new User();
                user.setId(res.getInt("id"));
                user.setName(res.getString("name"));
                user.setAge(res.getInt("age"));
                user.setSalary(res.getDouble("salary"));
                user.setPwd(res.getString("password"));
            }
            res.close();;
            ps.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();;
            throw new RuntimeException(e);
        }finally {
            dataSource.close(conn);
        }
    }
}
