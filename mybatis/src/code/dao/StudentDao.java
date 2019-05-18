package code.dao;

import pojo.Student;

/**
 * Student��dao�ӿڣ����ڹ���ѧ��
 */
public interface StudentDao {
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
    public void deleteStudent(int sno) throws Exception;

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
}
