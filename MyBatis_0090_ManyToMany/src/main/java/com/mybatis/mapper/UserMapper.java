package com.mybatis.mapper;

import com.mybatis.model.User;
import com.mybatis.vo.UserItems;

import java.util.List;

/**
 * Created by pl on 2015/9/21.
 */
public interface UserMapper {
    /**
     * 查询用户信息,关联的订单对象，订单对象关联的订单详情，订单详情关联的商品信息
     */
    public List<User> findUserOrdersOrderDetailItem() throws Exception;

    /**
     * 查询用户商品信息
     * @return
     * @throws Exception
     */
    public List<UserItems> findUserItems() throws Exception;
}
