package pojo;

import java.util.List;

/**
 * Student类的pojo包装对象
 */
public class StudentQueryVo {
    // 在这里包装所有的查询条件

    // 学生
    // 使用扩展类继承Student类
    private  StudentCustom studentCustom;

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }

    // 其他查询条件。。。。。
    private List<Integer> snos;

    public List<Integer> getSnos() {
        return snos;
    }

    public void setSnos(List<Integer> snos) {
        this.snos = snos;
    }
}
