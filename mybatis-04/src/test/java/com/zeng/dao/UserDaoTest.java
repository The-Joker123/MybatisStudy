package com.zeng.dao;

import com.zeng.pojo.User;
import com.zeng.untils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void test() {
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
        User user=userDao.getUserById(3);

        System.out.println(user);

        sqlSession.close();
    }

//    @Test
//    public void getByLimit()  {
//
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper userDao=sqlSession.getMapper(UserMapper.class);
//        Map<String,Integer> map=new HashMap<String, Integer>();
//        map.put("startIndex",1);
//        map.put("pageIndex",2);
//
//        List<User> userList=userDao.getUserByLimit(map);
//
//            System.out.println(userList);
//
//
//        sqlSession.close();
//    }


}
