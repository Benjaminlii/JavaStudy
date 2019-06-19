package po;

public class StudentQueryVo {
    //Student部分
    private StudentCustom studentCustom;

    public StudentCustom getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(StudentCustom studentCustom) {
        this.studentCustom = studentCustom;
    }

    @Override
    public String toString() {
        return "StudentQueryVo{" +
                "studentCustom=" + studentCustom +
                '}';
    }
}
