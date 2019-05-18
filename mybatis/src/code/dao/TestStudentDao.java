package code.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestStudentDao {
    private SqlSessionFactory sqlSessionFactory;

    public TestStudentDao() {
        try (
                InputStream inputStream = Resources.getResourceAsStream("config/SqlMapConfig.xml");
        ) {
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    // ≤‚ ‘studentDao
    public void testFindStudentById() throws Exception {
        StudentDao studentDao = new StudentDaoImpl(sqlSessionFactory);
        System.out.println(studentDao.findStudentBySno(2));
    }
}
