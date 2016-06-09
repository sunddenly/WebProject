package com.hebut.mvc.webbasic.ioc;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//通用层注解，默认ID jDBCDataSource
@Component("jdbcDataSource")
public class JDBCDataSource implements Serializable {
    @Value("#{db.driver}")
    private String driver;
    @Value("#{db.url}")
    private String url;
    @Value("#{db.username}")
    private String user;
    @Value("#{db.password}")
    private String pwd;
    public void setUrl(String url) {
        this.url = url;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void setDriver(String driver) {
        ;try{
            //注册驱动数据
            Class.forName(driver);
            this.driver=driver;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    //必须使用Bean属性注入，否则不能执行JDBC Driver注册
    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(url, user, pwd);
        System.out.println(conn);
        return conn;
    }
    public void close(Connection conn)  {
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
