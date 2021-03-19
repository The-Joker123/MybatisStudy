import com.zeng.dao.BlogMapper;
import com.zeng.pojo.Blog;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);
    @Test
    //一级缓存SqlSession测试
    public void testqueryBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        SqlSession sqlSession3= MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        BlogMapper blogMapper2= sqlSession2.getMapper(BlogMapper.class);
        BlogMapper blogMapper3= sqlSession3.getMapper(BlogMapper.class);

        HashMap<String,String> hashMap=new HashMap<String,String>();
//        hashMap.put("title","你好");
//        hashMap.put("author","曾自喜");
        List<Blog> blogList = blogMapper.queryBlogif(hashMap);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
        System.out.println("================================================");
        HashMap<String,String> hashMap1=new HashMap<String,String>();
//        hashMap.put("title","你好");
//        hashMap.put("author","曾自喜");
        List<Blog> blogList1 = blogMapper2.queryBlogif(hashMap);
        for (Blog blog : blogList1) {
            System.out.println(blog);
        }
        sqlSession2.close();
        System.out.println("================================================");
        HashMap<String,String> hashMap2=new HashMap<String,String>();
//        hashMap.put("title","你好");
//        hashMap.put("author","曾自喜");
        List<Blog> blogList3 = blogMapper3.queryBlogif(hashMap);
        for (Blog blog : blogList3) {
            System.out.println(blog);
        }
        sqlSession2.close();


    }
}
