package com.nueudu.dao;

import com.nueudu.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUser();
    void updateUser(User user);
    void delUser(User user);


}
