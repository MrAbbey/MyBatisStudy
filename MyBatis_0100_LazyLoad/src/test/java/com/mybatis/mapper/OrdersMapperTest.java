package com.mybatis.mapper;

import com.mybatis.model.Orders;
import com.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class OrdersMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @org.junit.Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @org.junit.Test
    public void testFindOrderUserInfo() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orderList = ordersMapper.findOrderUserInfo();
        for(Orders orders : orderList){

            User user = orders.getUser();
            System.out.println(orders +"-------------"+ user);
        }
        sqlSession.close();
    }
}