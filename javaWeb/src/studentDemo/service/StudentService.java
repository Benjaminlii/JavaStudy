package studentDemo.service;

import studentDemo.dao.StudentDao;
import studentDemo.entity.Student;

import java.util.List;

public class StudentService {
    /**
     * ��web���ݿ��е�student���в���һ������
     * @param stu Ҫ��������ݵ�Student�����װ
     * @return ������ɹ�������true�����򷵻�false
     */
    public static boolean addStudent(Student stu) {
        boolean rtn = false;
        //�ж��Ƿ���ڸ����ݣ�����������룬���������ʧ��
        if (!StudentDao.isExist(stu.getSno())) {
            rtn = StudentDao.addStudent(stu);
        }
        return rtn;
    }

    /**
     * ����student���е���������
     * @return ������student���е�������ɵ�һ����Student��ɵ�List
     */
    public  static List<Student> findAllStudents(){
        return StudentDao.findAllStudents();
    }

    /**
     * ɾ��һ��student����
     * @param sno ��Ҫɾ�����ݵ�sno
     * @return �ɹ�����true�� ���򷵻�false
     */
    public  static boolean deleteStudent(int sno){
        return StudentDao.deleteStudent(sno);
    }

    /**
     * ����һ������
     * @param sno ��Ҫ���µ����ݵ�sno
     * @param stu �µ�����
     * @return �ɹ�����true�����򷵻�false
     */
    public static boolean updateStudent(int sno, Student stu){
        return StudentDao.updataStudent(sno, stu);
    }
}
