package com.mybatis.mapper;

import com.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @org.junit.Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @org.junit.Test
    public void testFindUserById() throws Exception {
        //step1:打开多个Session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        //step2:第一次查询从数据库中直接查询
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.findUserById(30);
        System.out.println(user1);
        sqlSession.close();

        //step3:验证在调用session commit的情况下缓存是否清空
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        user1.setUsername("xuanxinpl");
        userMapper3.updateUserInfo(user1);
        sqlSession3.commit();
        sqlSession3.close();

        //step4：验证是否从缓存中取数据
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findUserById(30);
        System.out.println(user2);
        sqlSession2.close();
        sqlSession.commit();
    }
}