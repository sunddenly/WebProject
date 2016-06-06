package com.hebut.mvc.webbasic.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;

//持久层注解，指定约定的ID userDao 方便后面注入
@Repository("userDao")
public class MySqlUserDao implements UserDao {
    private JDBCDataSource dataSource;

    //空参数构造器，带实参时需要注入才行
    public MySqlUserDao() {

    }

    public JDBCDataSource getDataSource() {
        return dataSource;
    }
    //按照类型自动装配
    @Autowired
    public void setDataSource(@Qualifier("jdbcDataSource") JDBCDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findByName(String name) {
        String SQL1 = "SELECT * FROM users WHERE name=?";
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
                user.setPhone(res.getString("phone"));
                user.setPwd(res.getString("pwd"));
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
