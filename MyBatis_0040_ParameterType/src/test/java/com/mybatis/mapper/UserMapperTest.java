package com.mybatis.mapper;

import com.mybatis.model.User;
import com.mybatis.model.UserCustom;
import com.mybatis.pojo.QueryUserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryUserVO queryUserVO = new QueryUserVO();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("1");
        userCustom.setUsername("小明");
        queryUserVO.setUserCustom(userCustom);
        List<User> users = userMapper.findUserList(queryUserVO);
        System.out.println(users);
    }

    @org.junit.Test
    public void testFindUserByMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Object> mapParam = new HashMap<String, Object>();
        mapParam.put("sex","1");
        //在这里设置属性的时候,不要和系统中设置的属性重名
        mapParam.put("usernameKey","小明");
        List<User> users = userMapper.findUserByMap(mapParam);
        System.out.println(users);
    }
}