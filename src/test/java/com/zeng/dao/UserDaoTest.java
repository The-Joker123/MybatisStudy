package com.zeng.dao;

import com.zeng.pojo.User;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        UserDao userDao=sqlSession.getMapper(UserDao.class);
        List<User> userList=userDao.getUserList();

        for(User user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
