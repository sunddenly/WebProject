package com.hebut.ioc.autodi;

import com.hebut.ioc.constrcutor.User;
import com.hebut.ioc.constrcutor.UserDao;

/**
 * Created by jxy on 2016/6/5.
 */
public class UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User Login(String name, String pwd) {
        try{
            User user = userDao.findByName(name);
            if (user.getPwd().equals(pwd)){
                return user;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
