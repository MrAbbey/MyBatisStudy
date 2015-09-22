package com.mybatis.mapper;
import com.mybatis.model.Orders;
import java.util.List;
/**
 * Created by pl on 2015/9/21.
 */
public interface OrdersMapper {
    /**
     * 查询订单的信息,关联查询用户的信息
     * 这里订单<-一对一->用户
     * @return
     * @throws Exception
     */
    public List<Orders> findOrderUserInfo() throws Exception;
}
