import com.zeng.dao.BlogMapper;
import com.zeng.pojo.Blog;
import com.zeng.utils.IDutils;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class myTest {
    @Test
    public void testAddBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog=new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("你好");
        blog.setAuthor("曾自喜");
        blog.setCreateTime(new Date());
        blog.setViews(1314);
        blogMapper.addBlog(blog);

        sqlSession.close();

    }
    @Test
    public void testqueryBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,String> hashMap=new HashMap<String,String>();
//        hashMap.put("title","你好");
        hashMap.put("author","曾自喜");
        List<Blog> blogList = blogMapper.queryBlogif(hashMap);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
