package com.hebut.mvc.webbasic.ioc;

import java.io.Serializable;

/**
 * Created by jxy on 2016/6/5.
 */
public class User implements Serializable{
    private int id;
    private String name;
    private String pwd;
    private String phone;
    public User(){

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    @Override
    public int hashCode() {
        return id ;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj==null)
            return false;
        if(obj instanceof User){
            User u = (User) obj;
            return this.id==u.id;
        }
        return true;
    }

    @Override
    public String toString() {
        return id+","+name+","+pwd+","+phone;
    }
}
