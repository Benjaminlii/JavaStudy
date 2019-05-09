package addStudent.dao;

import addStudent.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对数据库进行原子性操作（增√、删、改、查√）
 */
public class StudentDao {
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
        Connection con = DBDao.getCon();
        String sql = "select * from student where sno = ? ;";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Student stu = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sno);
            rs = ps.executeQuery();
            if (rs.next()) {
                stu = new Student(rs.getInt("sno")
                        , rs.getString("sname")
                        , rs.getInt("sage")
                        , rs.getString("saddress"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }

    /**
     * 向数据库插入一个Student数据
     * @param stu 需要插入的数据的Student对象封装
     * @return 若插入成功，返回true，否则返回false
     */
    public static boolean addStudent(Student stu) {
        Connection con = DBDao.getCon();
        String sql = "insert into student (sno, sname, sage, saddress) values (?, ?, ?, ?);";
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, stu.getSno());
            ps.setString(2, stu.getSname());
            ps.setInt(3, stu.getSage());
            ps.setString(4, stu.getSaddress());

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count != 0;
    }
}
