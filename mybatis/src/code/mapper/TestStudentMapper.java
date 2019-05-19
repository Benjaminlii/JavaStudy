package code.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.StudentCustom;
import pojo.StudentQueryVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestStudentMapper {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml")
        ) {
            TestStudentMapper.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindStudentBySno() throws Exception {
        //得到SqlSession，这是不可少的步骤
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession得到代理的mapper接口对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        System.out.println(studentMapper.findStudentBySno(2));

        sqlSession.close();
    }

    @Test
    public void TestFindStudentBySname() throws Exception {
        //得到SqlSession，这是不可少的步骤
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession得到代理的mapper接口对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        System.out.println(studentMapper.findStudentBySname("Ben"));

        sqlSession.close();
    }

    @Test
    public void TestfindStudentList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //构造包装类
        StudentQueryVo studentQueryVo = new StudentQueryVo();
        //包装类的成员变量Student扩展类
        StudentCustom studentCustom = new StudentCustom();
        studentCustom.setSage(18);
        studentCustom.setSaddress("xa");
        studentQueryVo.setStudentCustom(studentCustom);

        //查询
        List<StudentCustom> studentCustomList = studentMapper.findStudentList(studentQueryVo);

        for(StudentCustom studentCustom1 : studentCustomList){
            System.out.println(studentCustom1);
        }
        sqlSession.close();
    }
}
