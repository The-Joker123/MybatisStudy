import com.zeng.dao.TeacherMapper;
import com.zeng.pojo.Teacher;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void getTestTeacher(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.getTeacher(1);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }
}
