package com.mybatis.daodesign.dao.impl;

import com.mybatis.daodesign.dao.UserDao;
import com.mybatis.daodesign.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    private UserDao userDao;

    @org.junit.Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        userDao = new UserDaoImpl(sqlSessionFactory);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testFindUserById() throws Exception {
        User user = userDao.findUserById(27);
        System.out.println(user);
    }

    @org.junit.Test
    public void testFindUserByName() throws Exception {
        List<User> users = userDao.findUserByName("小明");
        System.out.println(users);
    }

    @org.junit.Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUsername("彭磊");
        user.setAddress("湖北随州");
        user.setBirthday(new Date());
        user.setSex("男");
        int id = userDao.insertUser(user);
        Assert.assertEquals(30,id);
    }

    @org.junit.Test
    public void testDeleteUserById() throws Exception {
        userDao.deleteUserById(27);
    }

    @org.junit.Test
    public void testUpdateUserInfo() throws Exception {
        User user = new User();
        user.setId(30);
        user.setUsername("彭磊update");
        user.setAddress("湖北随州update");
        user.setBirthday(new Date());
        user.setSex("男");
        userDao.updateUserInfo(user);
    }
}