package code.mapper;

import pojo.Student;

import java.util.List;

/**
 * Student��dao�ӿڣ����ڹ���ѧ��
 */
public interface StudentMapper {
    /**
     * ����Student��Ϣ
     * @param student ��Ҫ�����Student����
     * @throws Exception
     */
    public void insertStudent(Student student) throws Exception;

    /**
     * ����snoɾ��ѧ����Ϣ
     * @param sno ��Ҫɾ����ѧ����sno
     * @throws Exception
     */
    public void deleteStudentBySno(int sno) throws Exception;

    /**
     * ����Student��Ϣ
     * @param student �������Ҫ�޸ĵ�Sutdent���µ���Ϣ
     * @throws Exception
     */
    public void updateStudent(Student student) throws Exception;

    /**
     * ͨ��sno��ѯѧ��
     * @param sno ��Ҫ��ѯ��ѧ����sno
     * @return ��ѯ����Student����
     * @throws Exception
     */
    public Student findStudentBySno(int sno) throws Exception;

    /**
     * ͨ��ѧ������ģ����ѯ��
     * ������Ҫע����ǣ�mybatis�ڽ��д������ɽӿ�ʵ�ֶ���ʱ������ݷ���ֵ�Ĳ�ͬѡ���Եĵ���selectOne��selectList
     * @param sname ģ����ѯ��ѧ������
     * @return ��ѯ����ѧ����ѧ����list
     * @throws Exception
     */
    public List<Student> findStudentBySname(String sname) throws Exception;
}
