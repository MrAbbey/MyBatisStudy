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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //Test1:测试两次相同的查询,是否只发出一条SQL语句
        User user1 = userMapper.findUserById(30);
        System.out.println(user1);
        //Test2:当调用commit方法的时候，系统会自动的清空内存中的缓存，避免脏读
        sqlSession.commit();
        User user2 = userMapper.findUserById(30);
        System.out.println(user2);
        sqlSession.commit();
    }
}