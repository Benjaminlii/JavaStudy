package code.dao;

import pojo.Student;

/**
 * Student的dao接口，用于管理学生
 */
public interface StudentDao {
    /**
     * 插入Student信息
     * @param student 需要插入的Student对象
     * @throws Exception
     */
    public void insertStudent(Student student) throws Exception;

    /**
     * 根据sno删除学生信息
     * @param sno 需要删除的学生的sno
     * @throws Exception
     */
    public void deleteStudent(int sno) throws Exception;

    /**
     * 更新Student信息
     * @param student 传入的需要修改的Sutdent的新的信息
     * @throws Exception
     */
    public void updateStudent(Student student) throws Exception;

    /**
     * 通过sno查询学生
     * @param sno 需要查询的学生的sno
     * @return 查询到的Student对象
     * @throws Exception
     */
    public Student findStudentBySno(int sno) throws Exception;
}
