package addStudent.service;

import addStudent.dao.StudentDao;
import addStudent.entity.Student;

public class StudentService {
    /**
     * 向web数据库中的student表中插入一条数据
     * @param stu 要插入的数据的Student对象封装
     * @return 若插入成功，返回true，否则返回false
     */
    public static boolean addStudent(Student stu) {
        boolean rtn = false;
        //判断是否存在该数据，不存在则插入，存在则插入失败
        if (!StudentDao.isExist(stu.getSno())) {
            rtn = StudentDao.addStudent(stu);
        }
        return rtn;
    }
}
