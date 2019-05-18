package code.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Student;

/**
 * StudentDao�Ľӿ�ʵ����
 */
public class StudentDaoImpl implements StudentDao {
    private SqlSessionFactory sqlSessionFactory;

    public StudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insertStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("student.insertStudent", student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteStudent(int sno) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("student.deleteStudentById", sno);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("student.updateStudentById", student);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Student findStudentBySno(int sno) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = sqlSession.selectOne("student.findStudentById", sno);
        //�ͷ���Դ
        sqlSession.close();
        return student;
    }
}
