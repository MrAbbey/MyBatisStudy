package com.mybatis.mapper;

import com.mybatis.model.User;

/**
 * Created by pl on 2015/9/20.
 */
public interface UserMapper {
    public User findUserById(int id) throws Exception;
}
