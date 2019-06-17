package po;

public class Student {
    private int sno;
    private String sname;
    private int sage;

    public Student(int sno, String sname, int sage) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                '}';
    }
}
