package com.mybatis.mapper;

import com.mybatis.model.User;
import com.mybatis.pojo.QueryUserVO;

import java.util.List;

/**
 * Created by pl on 2015/9/20.
 */
public interface UserMapper {
    public List<User> findUserList(QueryUserVO queryUserVO) throws Exception;

    public int findUserCount(QueryUserVO queryUserVO) throws Exception;

    public List<User> findUserByIds(int[] ids) throws Exception;
}
