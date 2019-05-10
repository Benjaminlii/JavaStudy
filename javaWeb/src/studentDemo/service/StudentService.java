package studentDemo.service;

import studentDemo.dao.StudentDao;
import studentDemo.entity.Student;

import java.util.List;

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

    /**
     * 查找student表中的所有数据
     * @return 返回由student表中的数据组成的一个个Student组成的List
     */
    public  static List<Student> findAllStudents(){
        return StudentDao.findAllStudents();
    }

    /**
     * 删除一条student数据
     * @param sno 需要删除数据的sno
     * @return 成功返回true， 否则返回false
     */
    public  static boolean deleteStudent(int sno){
        return StudentDao.deleteStudent(sno);
    }

    /**
     * 更新一条数据
     * @param sno 需要更新的数据的sno
     * @param stu 新的数据
     * @return 成功返回true，否则返回false
     */
    public static boolean updateStudent(int sno, Student stu){
        return StudentDao.updataStudent(sno, stu);
    }
}
