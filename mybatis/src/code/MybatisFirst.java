package code;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisFirst {
    @Test

    // ����ѧ����sno��ѯѧ��
    // ����ʹ��mybatis�������ݿ�Ĳ���
    public void findStudentByIdTest() {
        //���mybatis�����ļ�
        String resource = "config/SqlMapConfig.xml";
        SqlSession sqlSession = null;
        try ( //�õ������ļ�����
              InputStream inputStream = Resources.getResourceAsStream(resource)
        ) {
            //�����Ự���������������ļ���Ϣ
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //ͨ�������õ�SqlSession
            sqlSession = sqlSessionFactory.openSession();

            //ͨ��SqlSession�������ݿ�
            //��һ��������ӳ���ļ�studentMapper.xml�е�statement��id����ֵ����namePlace + "." + statementId
            //�ڶ���������ӳ���ļ������õ�Ҫ����Ĳ���������ƥ��Ķ���
            Student student = sqlSession.selectOne("test.findStudentById", 4173188);

            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    @Test
    public void findStudentByName(){
        String resource = "config/SqlMapConfig.xml";
        SqlSession sqlSession = null;
        try (
              InputStream inputStream = Resources.getResourceAsStream(resource)
        ) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            List<Student> students = sqlSession.selectList("test.findStudentByName", "l");
            for(Student student : students){
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }
}
