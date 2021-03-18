package com.zeng.dao;

import com.zeng.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);
    List<Blog> queryBlogif(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlogSet(Map map);
}
