import java.util.Scanner;

/**
 * 与PTA上的运算结果不一致，小数点后15位的地方小了一点
 * 算法肯定没问题，不然不可能差这么少
 *
 * 测试点：
 * 1：未知
 * 2：不相交
 * 3： 12.3 44.4 56.78 -12.33 22.23 -22.12 11.2 22.11
 *     The intersecting point is at (2.5357634334946955, 56.85335297701992)
 *
 * author:Benjamin
 */

class Point {
    private double x;
    private double y;
    private boolean flag = false;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(line l1, line l2) {
        if(l1.getK() == l2.getK()){
            this.flag = false;
        }else {
            this.flag = true;
            this.x = (l2.getB() - l1.getB()) / (l1.getK() - l2.getK());
            this.y = this.x * l1.getK() + l1.getB();
        }
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    void printPoint() {
        if(this.flag){
            System.out.println("The intersecting point is at (" + this.x + ", " + this.y + ")");
        }else{
            System.out.println("The two lines are parallel");
        }
    }
}

class line {
    private double k;
    private double b;

    line(Point p1, Point p2) {
        this.k = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        this.b = p1.getY() - this.k * p1.getX();
    }

    double getK() {
        return k;
    }

    double getB() {
        return b;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Point p1 = new Point(in.nextDouble(), in.nextDouble());
        Point p2 = new Point(in.nextDouble(), in.nextDouble());
        Point p3 = new Point(in.nextDouble(), in.nextDouble());
        Point p4 = new Point(in.nextDouble(), in.nextDouble());

        line l1 = new line(p1, p2);
        line l2 = new line(p3, p4);

        Point interPoint = new Point(l1, l2);
        interPoint.printPoint();

        in.close();
    }
}
