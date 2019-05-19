package code.mapper;

import pojo.Student;

import java.util.List;

/**
 * Student的dao接口，用于管理学生
 */
public interface StudentMapper {
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
    public void deleteStudentBySno(int sno) throws Exception;

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

    /**
     * 通过学生姓名模糊查询，
     * 这里需要注意的是，mybatis在进行代理生成接口实现对象时，会根据返回值的不同选择性的调用selectOne或selectList
     * @param sname 模糊查询的学生姓名
     * @return 查询出的学生的学生的list
     * @throws Exception
     */
    public List<Student> findStudentBySname(String sname) throws Exception;
}
