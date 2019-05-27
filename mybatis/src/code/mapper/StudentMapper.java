package code.mapper;

import pojo.Student;
import pojo.StudentCustom;
import pojo.StudentQueryVo;

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

    /**
     * 用户信息的综合查询
     * 通过studentQueryVo包装类包装查询时所用到的所有信息（类），作为参数传入
     * 在sql中调用其中的属性即可
     * @param studentQueryVo 查询时会用到的所有信息所包装成的包装类
     * @return 因为不确定查询的字段值，所以使用扩展类（或其容器）来接收查询结果
     * @throws Exception
     */
    public List<StudentCustom> findStudentList(StudentQueryVo studentQueryVo) throws Exception;

    /**
     * 使用动态sql
     * @param studentQueryVo 查询时会用到的所有信息所包装成的包装类
     * @return 因为不确定查询的字段值，所以使用扩展类（或其容器）来接收查询结果
     * @throws Exception
     */
    public List<StudentCustom> findStudentListDynamicSQL(StudentQueryVo studentQueryVo) throws Exception;

    /**
     * 通过resultMap进行输出映射，将不可识别的字段名映射为Student对象
     * @param studentQueryVo 查询时会用到的所有信息所包装成的包装类
     * @return
     * @throws Exception
     */
    public List<Student> findStudentListResultMap(StudentQueryVo studentQueryVo) throws Exception;
}
