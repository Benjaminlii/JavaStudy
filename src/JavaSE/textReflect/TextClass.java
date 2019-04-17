package JavaSE.textReflect;

import java.lang.reflect.Modifier;

/**
 * 开始学习反射
 * <p>
 * author:Benjamin
 * date:2019.3.31
 */

public class TextClass {
    public static void main(String[] args) throws ClassNotFoundException {
        methor_1();
    }

    /**
     * 得到某个类的Class对象的三种方法
     * 1、每个类的内部都会由静态的属性，为该类的Class类对象
     * 2、对该类的某一个实例化对象使用getClass（）方法可以得到该类的Class对象
     * 3、通过Class.forName(String s)方法
     * 可以由一个字符串在当前目录下找到字符串对应的.class文件，从而得到字符串对应的Class对象
     * <p>
     * 程序运行过程中，会提前加载类，但只有在进行第一次实例化时，才会进行类的初始化，1、2两种方法都不会初始化类对象，3会
     *
     * @throws ClassNotFoundException
     */
    public static void methor_0() throws ClassNotFoundException {
        Class c1 = Person.class;
        System.out.println("Person.class");

        Class c2 = (new Person()).getClass();
        System.out.println("(new Person()).getClass()");

        Class c3 = Class.forName("JavaSE.textReflect.Person"); // 这里需要完整类名（包名.类名）
        System.out.println("Class.forName(\"Person\")");

        System.out.println("if c1==c2==c3 : " + (c1 == c2 & c2 == c3));
    }

    public static void methor_1() throws ClassNotFoundException {
        //获得Class对象
        Class one = String.class;

        //类的修饰符
        //Class.getModifiers()返回代表类的修饰信息的int
        // Modifier类为修饰信息类，toString()方法可以由int转String
        System.out.println(Modifier.toString(one.getModifiers()));

        //类名
        System.out.println("class : (" + one.getName() + ") or (" + one.getSimpleName() + ")");

        //父类
        System.out.println("superClass : " + one.getSuperclass());

        //接口
        Class[] interfaces = one.getInterfaces();
        System.out.println("interfaces : ");
        for(Class o:interfaces){
            System.out.println("\t" + o + " ");
        }
    }
}

class Person {
    static {
        System.out.println("Init class Person.");
    }
}

final class Dog {
    private String name;
    public int age;
    protected String color;
}