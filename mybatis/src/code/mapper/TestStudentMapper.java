package code.mapper;

import code.dao.TestStudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
}
