package com.mybatis.daodesign.dao;

import com.mybatis.daodesign.model.User;

import java.util.List;

/**
 * Created by pl on 2015/9/20.
 */
public interface UserDao {
    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String username) throws Exception;

    public int insertUser(User user) throws Exception;

    public void deleteUserById(int id) throws Exception;

    public void updateUserInfo(User user) throws Exception;
}
