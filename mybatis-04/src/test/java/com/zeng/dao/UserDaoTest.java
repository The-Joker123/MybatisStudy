package com.zeng.dao;

import com.zeng.pojo.User;
import com.zeng.untils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import com.zeng.untils.initLogRecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void test() throws FileNotFoundException {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        User user=userDao.getUserById(3);

        System.out.println(user);

        sqlSession.close();
    }


}
