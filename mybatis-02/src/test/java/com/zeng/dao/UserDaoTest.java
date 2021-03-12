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


}
