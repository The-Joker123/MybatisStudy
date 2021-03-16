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
    @Test
    public void testGetUserById(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        User user=userDao.getUserByID(2);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testAddUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        User user=new User(7,"小李","123456");
        int result=userDao.addUser(user);
        if(result>0){
            System.out.println("增加成功");
        }

        sqlSession.close();
    }
    @Test
    public void testUpdateUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        User user=new User(7,"小王","667788");
        int result=userDao.updateUser(user);
        if(result>0){
            System.out.println("修改成功");
        }

        sqlSession.close();
    }

    @Test
    public void testDeleteUser(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);

        int result=userDao.deleteUser(7);
        if(result>0){
            System.out.println("删除成功");
        }

        sqlSession.close();
    }



}
