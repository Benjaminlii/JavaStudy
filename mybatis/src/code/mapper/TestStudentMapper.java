package code.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Student;
import pojo.StudentCustom;
import pojo.StudentQueryVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        //�õ�SqlSession�����ǲ����ٵĲ���
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //ͨ��SqlSession�õ������mapper�ӿڶ���
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        System.out.println(studentMapper.findStudentBySno(2));

        sqlSession.close();
    }

    @Test
    public void TestFindStudentBySname() throws Exception {
        //�õ�SqlSession�����ǲ����ٵĲ���
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //ͨ��SqlSession�õ������mapper�ӿڶ���
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        System.out.println(studentMapper.findStudentBySname("Ben"));

        sqlSession.close();
    }

    @Test
    public void TestfindStudentList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //�����װ��
        StudentQueryVo studentQueryVo = new StudentQueryVo();
        //��װ��ĳ�Ա����Student��չ��
        StudentCustom studentCustom = new StudentCustom();
        studentCustom.setSage(18);
        studentCustom.setSaddress("xa");
        studentQueryVo.setStudentCustom(studentCustom);

        //��ѯ
        List<StudentCustom> studentCustomList = studentMapper.findStudentList(studentQueryVo);

        for(StudentCustom studentCustom1 : studentCustomList){
            System.out.println(studentCustom1);
        }
        sqlSession.close();
    }

    @Test
    public void findStudentListDynamicSQL() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //�����װ��
        StudentQueryVo studentQueryVo = new StudentQueryVo();
        //��װ��ĳ�Ա����Student��չ��
        StudentCustom studentCustom = new StudentCustom();
//        studentCustom.setSname("en");
//        studentCustom.setSage(19);
//        studentCustom.setSaddress("xa");
        List<Integer> snos = new ArrayList<>();
        snos.add(1);
        snos.add(4);
        snos.add(7);

        studentQueryVo.setStudentCustom(studentCustom);
        studentQueryVo.setSnos(snos);

        //��ѯ
        List<StudentCustom> studentCustomList = studentMapper.findStudentListDynamicSQL(studentQueryVo);

        for(StudentCustom studentCustom1 : studentCustomList){
            System.out.println(studentCustom1);
        }
        sqlSession.close();
    }

    @Test
    public void TextFindStudentListResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //�����װ��
        StudentQueryVo studentQueryVo = new StudentQueryVo();
        //��װ��ĳ�Ա����Student��չ��
        StudentCustom studentCustom = new StudentCustom();
        studentCustom.setSage(18);
//        studentCustom.setSaddress("xa");
        studentQueryVo.setStudentCustom(studentCustom);

        //��ѯ
        List<Student> studentCustomList = studentMapper.findStudentListResultMap(studentQueryVo);

        for(Student student : studentCustomList){
            System.out.println(student);
        }
        sqlSession.close();
    }
}
