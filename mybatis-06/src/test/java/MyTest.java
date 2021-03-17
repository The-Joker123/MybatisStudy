import com.zeng.dao.StudentMapper;
import com.zeng.dao.TeacherMapper;
import com.zeng.pojo.Student;
import com.zeng.pojo.Teacher;
import com.zeng.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void teatGetTeacher(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher =teacherMapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void teatGetStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();

    }
    @Test
    public void teatGetStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudent2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();

    }
}
