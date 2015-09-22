package com.mybatis.curd;

import com.mybatis.curd.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by pl on 2015/9/20.
 */
public class MyBatisCURDTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //根据用户的ID查询用户信息
    @Test
    public void testFindUserById() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",1);
        System.out.println(user);
        sqlSession.close();
    }

    //查询用户的信息列表通过用户名称
    @Test
    public void testFindUsersByName() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> user = sqlSession.selectList("test.findUserByName","小明");
        System.out.println(user);
        sqlSession.close();
    }

    //插入用户信息
    @Test
    public void testInsertUser() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("彭磊");
        user.setAddress("湖北随州");
        user.setSex("男");
        user.setBirthday(new Date());
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        System.out.println(user.getId());
        sqlSession.close();
    }

    //删除用户信息
    @Test
    public void testDeleteUserById() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById",28);
        sqlSession.commit();
        sqlSession.close();
    }

    //修改用户信息
    @Test
    public void testupdateUserInfo() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(27);
        user.setUsername("penglei");
        user.setAddress("湖北襄阳");
        user.setSex("男");
        user.setBirthday(new Date());
        sqlSession.update("test.updateUserInfo",user);
        sqlSession.commit();
        sqlSession.close();
    }

}
