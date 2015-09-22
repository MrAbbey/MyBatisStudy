package com.mybatis.mapper;

import com.mybatis.model.User;
import com.mybatis.pojo.QueryUserVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pl on 2015/9/20.
 */
public interface UserMapper {
    public User findUserByIdResultMap(int id) throws Exception;
}
