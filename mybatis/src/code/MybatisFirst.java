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

    // 根据学生的sno查询学生
    // 初次使用mybatis进行数据库的操作
    public void findStudentByIdTest() {
        //添加mybatis配置文件
        String resource = "config/SqlMapConfig.xml";
        SqlSession sqlSession = null;
        try ( //得到配置文件的流
              InputStream inputStream = Resources.getResourceAsStream(resource)
        ) {
            //创建会话工厂，载入配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过工厂得到SqlSession
            sqlSession = sqlSessionFactory.openSession();

            //通过SqlSession操作数据库
            //第一个参数是映射文件studentMapper.xml中的statement的id，其值等于namePlace + "." + statementId
            //第二个参数是映射文件中设置的要传入的参数类型所匹配的对象
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
