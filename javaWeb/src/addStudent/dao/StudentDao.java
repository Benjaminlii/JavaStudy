package addStudent.dao;

import addStudent.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �����ݿ����ԭ���Բ��������̡�ɾ���ġ���̣�
 */
public class StudentDao {
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
     * �����ݿ����һ��Student����
     * @param stu ��Ҫ��������ݵ�Student�����װ
     * @return ������ɹ�������true�����򷵻�false
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
