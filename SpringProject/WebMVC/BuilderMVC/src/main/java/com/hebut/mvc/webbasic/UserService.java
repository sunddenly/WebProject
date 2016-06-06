package com.hebut.mvc.webbasic;

import com.hebut.mvc.webbasic.ioc.User;
import com.hebut.mvc.webbasic.ioc.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

//业务层注解，默认Bean ID为 userService
@Service
public class UserService implements Serializable{
    //自动匹配注入userDao，或者为@Resource(name="mysqlUserDao")
    @Resource
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    //系统登陆功能
    public User login(String name,String pwd) throws NullParamException, NameOrPwdException {
        if(name==null||name.equals("")||pwd==null||pwd.equals("")){
            throw new NullParamException("登录参数不能为空！");
        }
        User user = userDao.findByName(name);
        if(user!=null&&pwd.equals(user.getPwd())){
            return user;
        }
        throw new NameOrPwdException("用户名或密码错误！");
    }
}
