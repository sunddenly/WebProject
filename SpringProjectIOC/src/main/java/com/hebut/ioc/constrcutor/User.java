package com.hebut.ioc.constrcutor;

import java.io.Serializable;

/**
 * Created by jxy on 2016/6/5.
 */
public class User implements Serializable{
    private int id;
    private String name;
    private String pwd;
    private double salary;
    private int age;
    public User(){

    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {

        return pwd;
    }

    public User(String name, double salary, int age) {
        super();
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
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
        return id+","+name+","+salary+","+age;
    }
}
