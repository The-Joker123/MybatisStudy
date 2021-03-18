import com.zeng.dao.BlogMapper;
import com.zeng.pojo.Blog;
import com.zeng.utils.IDutils;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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
    @Test
    public void testQueryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("title","你好");
//        hashMap.put("author","曾自喜");
        List<Blog> blogList = blogMapper.queryBlogChoose(hashMap);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
    @Test
    public void testUpdateBlogSet(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,String> hashMap=new HashMap<String,String>();

        hashMap.put("title","lalalalla");
        hashMap.put("id","b239e4c600ad433f8ccf15e36a20ae7c");
//        hashMap.put("author","曾自喜");
      int result= blogMapper.updateBlogSet(hashMap);
        if(result>0){
            System.out.println("修改成功");
        }

        sqlSession.close();
    }
    @Test
    public void testQueryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String,String> hashMap=new HashMap<String,String>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        arrayList.add(1);
        hashMap.put("id","你好");
//        hashMap.put("author","曾自喜");
        List<Blog> blogList = blogMapper.queryBlogChoose(hashMap);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

}
