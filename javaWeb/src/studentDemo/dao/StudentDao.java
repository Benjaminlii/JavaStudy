package studentDemo.dao;

import studentDemo.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * �����ݿ����ԭ���Բ��������̡�ɾ���ġ���̣�
 */
public class StudentDao {

    /**
     * �����ݿ����һ��Student����
     *
     * @param stu ��Ҫ��������ݵ�Student�����װ
     * @return ������ɹ�������true�����򷵻�false
     */
    public static boolean addStudent(Student stu) {
        Connection con = DBDao.getCon();
        String sql = "insert into student (sno, sname, sage, saddress) values (?, ?, ?, ?);";
        PreparedStatement ps;
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

    /**
     * ��student����ɾ��һ������
     *
     * @param sno ��Ҫɾ�������ݵ�sno
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public static boolean deleteStudent(int sno) {
        Connection con = DBDao.getCon();
        String sql = "delete from student where sno = ?;";
        PreparedStatement ps;
        int count = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sno);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    /**
     * ��Student����һ������
     *
     * @param sno ��Ҫ���ĵ���һ�����ݵ�sno������ȷ����Ҫ�޸ĵ�����
     * @param stu ���º������
     * @return �����ĳɹ�������true�������ɹ�������false
     */
    public static boolean updataStudent(int sno, Student stu) {
        Connection con = DBDao.getCon();
        String sql = "update student set sname = ?, sage = ?, saddress = ? where sno = ?;";
        PreparedStatement ps;
        int count = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, stu.getSname());
            ps.setInt(2, stu.getSage());
            ps.setString(3, stu.getSaddress());
            ps.setInt(4, sno);

            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    /**
     * �ж��Ƿ���ڸ�sno���ϵ�Student
     *
     * @param sno ������Ҫ�����жϴ��ڵ�Student��sno
     * @return �����ڷ���true���������ڷ���false
     */
    public static boolean isExist(int sno) {
        return findStudentBySno(sno) != null;
    }

    /**
     * ����sno����Student����
     *
     * @param sno Ҫ���в��ҵ�Student��sno
     * @return ���ҵ���Student������Student������δ�ҵ�������null
     */
    public static Student findStudentBySno(int sno) {
        Connection con = DBDao.getCon();
        String sql = "select * from student where sno = ? ;";
        PreparedStatement ps;
        ResultSet rs;
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
     * ����student���е���������
     * @return ������student���е�������ɵ�һ����Student��ɵ�List
     */
    public static List<Student> findAllStudents() {
        Connection con = DBDao.getCon();
        String sql = "select * from student";
        PreparedStatement ps;
        ResultSet rs;
        List<Student> stus = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                stus.add(new Student(rs.getInt("sno")
                                , rs.getString("sname")
                                , rs.getInt("sage")
                                , rs.getString("saddress")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stus;
    }
}
