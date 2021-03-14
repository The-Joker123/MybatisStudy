package com.zeng.dao;

import com.zeng.pojo.User;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        User user=userDao.getUserById(3);

        System.out.println(user);

        sqlSession.close();
    }


}
