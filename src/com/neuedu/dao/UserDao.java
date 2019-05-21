package com.neuedu.dao;

import com.neuedu.pojo.User;

//接口
public interface UserDao {
    void regsiter(String user,String psw);



    User login(User user);
}
