package addStudent.service;

import addStudent.dao.StudentDao;
import addStudent.entity.Student;

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
}
