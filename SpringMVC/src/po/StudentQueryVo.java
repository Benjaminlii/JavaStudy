package po;

public class StudentQueryVo {
    //Student部分
    private Student studentCustom;

    public Student getStudentCustom() {
        return studentCustom;
    }

    public void setStudentCustom(Student studentCustom) {
        this.studentCustom = studentCustom;
    }

    //toString

    @Override
    public String toString() {
        return "StudentQueryVo{" +
                "studentCustom=" + studentCustom +
                '}';
    }
}
