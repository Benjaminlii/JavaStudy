package code.mapper;

import pojo.Student;
import pojo.StudentCustom;
import pojo.StudentQueryVo;

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

    /**
     * �û���Ϣ���ۺϲ�ѯ
     * ͨ��studentQueryVo��װ���װ��ѯʱ���õ���������Ϣ���ࣩ����Ϊ��������
     * ��sql�е������е����Լ���
     * @param studentQueryVo ��ѯʱ���õ���������Ϣ����װ�ɵİ�װ��
     * @return ��Ϊ��ȷ����ѯ���ֶ�ֵ������ʹ����չ�ࣨ���������������ղ�ѯ���
     * @throws Exception
     */
    public List<StudentCustom> findStudentList(StudentQueryVo studentQueryVo) throws Exception;

    /**
     * ʹ�ö�̬sql
     * @param studentQueryVo ��ѯʱ���õ���������Ϣ����װ�ɵİ�װ��
     * @return ��Ϊ��ȷ����ѯ���ֶ�ֵ������ʹ����չ�ࣨ���������������ղ�ѯ���
     * @throws Exception
     */
    public List<StudentCustom> findStudentListDynamicSQL(StudentQueryVo studentQueryVo) throws Exception;

    /**
     * ͨ��resultMap�������ӳ�䣬������ʶ����ֶ���ӳ��ΪStudent����
     * @param studentQueryVo ��ѯʱ���õ���������Ϣ����װ�ɵİ�װ��
     * @return
     * @throws Exception
     */
    public List<Student> findStudentListResultMap(StudentQueryVo studentQueryVo) throws Exception;
}
