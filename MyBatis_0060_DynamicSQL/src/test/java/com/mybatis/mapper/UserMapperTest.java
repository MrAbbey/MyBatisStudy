package com.mybatis.mapper;

import com.mybatis.model.User;
import com.mybatis.model.UserCustom;
import com.mybatis.pojo.QueryUserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @org.junit.Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @org.junit.Test
    public void testFindUserList() throws Exception {
       SqlSession sqlSession =  sqlSessionFactory.openSession();
       UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryUserVO queryUserVO = new QueryUserVO();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        queryUserVO.setUserCustom(userCustom);
       List<User> userList = userMapper.findUserList(queryUserVO);
       System.out.println(userList.size());
       sqlSession.close();
    }

    @org.junit.Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryUserVO queryUserVO = new QueryUserVO();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("小明");
        queryUserVO.setUserCustom(userCustom);
        int count = userMapper.findUserCount(queryUserVO);
        System.out.println(count);
        sqlSession.close();
    }

    @org.junit.Test
    public void testFindUserByIds() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int[] ids = {24,25,26};
        List<User> users = userMapper.findUserByIds(ids);
        sqlSession.close();
        System.out.println(users);
    }
}