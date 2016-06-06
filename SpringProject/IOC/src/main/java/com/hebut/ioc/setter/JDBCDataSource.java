package com.hebut.ioc.setter;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jxy on 2016/6/5.
 */
public class JDBCDataSource implements Serializable {
    private String driver;
    private String url;
    private String user;
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
