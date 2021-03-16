package com.zeng.dao;

import com.zeng.pojo.User;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

//    @Test
//    public void test(){
//        SqlSession sqlSession= MybatisUtils.getSqlSession();
//        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
//        User user=userDao.getUserById(2);
//        System.out.println(user);
//        sqlSession.close();
//    }
    @Test
    public void test1(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userDao.getUsers();
        for(User user:userList){
            System.out.println(user);
        }
        sqlSession.close();
    }





}
