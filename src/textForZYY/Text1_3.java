package textForZYY;

/**
 * 一个类包含 私有域（也叫属性，包含访问限制、类型、变量名，因为访问限制通常修饰为私有，被称为私有域）
 *           方法（分为构造方法、get\set方法、普通方法）（方法有各自的访问限制、返回值、参数）
 *
 * 编写一个类
 * 类名为Rectangle（长方形）
 * 包含两个私有的double属性length（长）和width（宽），初始化为0
 *     一个初始化length和width的构造函数
 *     一个公共方法名为getArea，返回值为double，返回长方形的面积
 *     一个公共方法名为getPerimeter，返回值为double，返回长方形的周长
 *
 * 在公共类中进行测试
 *
 * author:zyy
 * date:2019.3.13
 */

class Rectangle{
    /*--------------------------code------------------------------*/
    private double length;
    private double width;
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    public double getArea(){
        return this.length * this.width;
    }
    public  double getPerimeter(){
        return 2*(this.width+this.length);
    }
}

public class Text1_3 {
    public static void main(String[] args) {
    Rectangle lt =new Rectangle(3,5);
        System.out.println(lt.getPerimeter());
        System.out.println(lt.getArea());
    }
}
