package pojo;

import java.util.List;

/**
 * Student���pojo��װ����
 */
public class StudentQueryVo {
    // �������װ���еĲ�ѯ����

    // ѧ��
    // ʹ����չ��̳�Student��
    private  StudentCustom studentCustom;

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }

    // ������ѯ��������������
    private List<Integer> snos;

    public List<Integer> getSnos() {
        return snos;
    }

    public void setSnos(List<Integer> snos) {
        this.snos = snos;
    }
}
