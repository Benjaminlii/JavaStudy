import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
abstract class Shape {

    abstract double getArea();

    static double getsumArea(Shape[] shapes) {
        double rtn = 0;
        for (Shape one : shapes)
            rtn += one.getArea();
        return rtn;
    }
}

class Circle extends Shape {

    private double ride;

    Circle(double ride) {
        this.ride = ride;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(this.ride, 2);
    }
}

class Rectangle extends Shape {

    private double side1;
    private double side2;

    Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    double getArea() {
        return this.side1 * this.side2;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.printf("The total area is %.4f", Shape.getsumArea(
                new Shape[]{
                        new Circle(in.nextDouble()),
                        new Circle(in.nextDouble()),
                        new Rectangle(in.nextDouble(), in.nextDouble()),
                        new Rectangle(in.nextDouble(), in.nextDouble())
                }
        ));

        in.close();
    }
}
