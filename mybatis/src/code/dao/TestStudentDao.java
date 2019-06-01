package code.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestStudentDao {
    private static SqlSessionFactory sqlSessionFactory;

    static  {
        try (
                InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml")
        ) {
            TestStudentDao.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    // 测试studentDao
    public void testFindStudentById() throws Exception {
        StudentDao studentDao = new StudentDaoImpl(sqlSessionFactory);
        System.out.println(studentDao.findStudentBySno(2));
    }
}
