package com.zeng.dao;

import com.zeng.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

//    User getUserById(int id);

    @Select("select * from user")
    List<User> getUsers();

    @Select("select *from user where id=#{id}")
    User getUserByID(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values(#{id},#{name},#{pwd})")
    int addUser(User user);


    @Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id")int id);
}
