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
        String sql = "insert into student (sno, sname, sage, saddress) values (?, ?, ?, ?);";
        Object[] para = {stu.getSno(), stu.getSname(), stu.getSage(), stu.getSaddress()};
        return DBUtil.executeUpdate("web", sql, para) != 0;
    }

    /**
     * ��student����ɾ��һ������
     *
     * @param sno ��Ҫɾ�������ݵ�sno
     * @return ɾ���ɹ�����true�����򷵻�false
     */
    public static boolean deleteStudent(int sno) {
        String sql = "delete from student where sno = ?;";
        Object[] para = {sno};
        return DBUtil.executeUpdate("web", sql, para) == 1;
    }

    /**
     * ��Student����һ������
     *
     * @param sno ��Ҫ���ĵ���һ�����ݵ�sno������ȷ����Ҫ�޸ĵ�����
     * @param stu ���º������
     * @return �����ĳɹ�������true�������ɹ�������false
     */
    public static boolean updataStudent(int sno, Student stu) {
        String sql = "update student set sname = ?, sage = ?, saddress = ? where sno = ?;";
        Object[] para = {stu.getSname(), stu.getSage(), stu.getSaddress(), stu.getSno()};
        return DBUtil.executeUpdate("web", sql, para) == 1;
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
     * ����student���е���������
     *
     * @return ������student���е�������ɵ�һ����Student��ɵ�List
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
