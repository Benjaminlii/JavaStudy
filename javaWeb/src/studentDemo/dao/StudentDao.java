package studentDemo.dao;

import studentDemo.entity.Student;
import studentDemo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 对数据库进行原子性操作（增√、删、改、查√）
 */
public class StudentDao {

    /**
     * 向数据库插入一个Student数据
     *
     * @param stu 需要插入的数据的Student对象封装
     * @return 若插入成功，返回true，否则返回false
     */
    public static boolean addStudent(Student stu) {
        String sql = "insert into student (sno, sname, sage, saddress) values (?, ?, ?, ?);";
        Object[] para = {stu.getSno(), stu.getSname(), stu.getSage(), stu.getSaddress()};
        return DBUtil.executeUpdate("web", sql, para) != 0;
    }

    /**
     * 在student表中删除一条数据
     *
     * @param sno 需要删除的数据的sno
     * @return 删除成功返回true，否则返回false
     */
    public static boolean deleteStudent(int sno) {
        String sql = "delete from student where sno = ?;";
        Object[] para = {sno};
        return DBUtil.executeUpdate("web", sql, para) == 1;
    }

    /**
     * 向Student更改一条数据
     *
     * @param sno 需要更改的那一条数据的sno，用来确定需要修改的数据
     * @param stu 更新后的数据
     * @return 若更改成功，返回true，若不成功，返回false
     */
    public static boolean updataStudent(int sno, Student stu) {
        String sql = "update student set sname = ?, sage = ?, saddress = ? where sno = ?;";
        Object[] para = {stu.getSname(), stu.getSage(), stu.getSaddress(), stu.getSno()};
        return DBUtil.executeUpdate("web", sql, para) == 1;
    }

    /**
     * 判断是否存在该sno符合的Student
     *
     * @param sno 传入需要进行判断存在的Student的sno
     * @return 若存在返回true，若不存在返回false
     */
    public static boolean isExist(int sno) {
        return findStudentBySno(sno) != null;
    }

    /**
     * 根据sno查找Student对象
     *
     * @param sno 要进行查找的Student的sno
     * @return 若找到该Student，返回Student对象，若未找到，返回null
     */
    public static Student findStudentBySno(int sno) {
        String sql = "select * from student where sno = ? ;";
        Object[] para = {sno};
        ResultSet rs;
        Student stu = null;
        try {
            rs = DBUtil.executeQuery("web", sql, para);
            if (rs.next()) {
                stu = new Student(rs.getInt("sno")
                        , rs.getString("sname")
                        , rs.getInt("sage")
                        , rs.getString("saddress")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return stu;
    }

    /**
     * 查找student表中的所有数据
     *
     * @return 返回由student表中的数据组成的一个个Student组成的List
     */
    public static List<Student> findAllStudents() {
        String sql = "select * from student";
        ResultSet rs;
        Student stu = null;
        List<Student> stus = new ArrayList<>();
        try {
            rs = DBUtil.executeQuery("web", sql, null);
            while (rs.next()) {
                stu = new Student(rs.getInt("sno")
                        , rs.getString("sname")
                        , rs.getInt("sage")
                        , rs.getString("saddress")
                );
                stus.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();
        }
        return stus;
    }
}
