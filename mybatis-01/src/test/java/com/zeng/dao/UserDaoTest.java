package com.zeng.dao;

import com.zeng.pojo.User;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        List<User> userList=userDao.getUserList();
        for(User user:userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getByID(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user= userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void getUserlike(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        List<User> userList= userMapper.getUserLike("小");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void getByID2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",2);
        User user= userMapper.getUserById2(map);
        System.out.println(user);
        sqlSession.close();
    }
//增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
       int res= userMapper.addUser(new User(4,"小明","112233"));
       if(res>0){
           System.out.println("插入成功");
       }
       sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("userid",6);
        map.put("username","小张");
        map.put("password","12345678");

        int res=userMapper.addUser2(map);
        if(res>0){
            System.out.println("插入成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int res=userMapper.updateUser(new User(2,"张三","11223344"));
        if(res>0){
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        int res=userMapper.deleteUser(4);
        if(res>0){
            System.out.println("删除成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
