package textGenerics;

import java.util.ArrayList;

/**
 * 测试泛型容器中的ArrayList
 * ArrayList相当于动态数组，查询速度快，插入删除速度慢，线程不安全
 * <p>
 * ArrayList<type> name = new ArrayList<type>();    创建一个关于类型type的ArrayList对象，后一个尖括号中的type可以省略
 * 构造器括号中可以加上参数，指定初始化Array List的大小
 * boolean ArrayList.add(type data);    在ArrayList尾部添加元素data，返回是否添加成功
 * void ArrayList.add(int n, type data);    在ArrayList下标为n的位置上插入元素data，无返回值
 * type ArrayList.set(int n, type data);    设置ArrayList下标为n位置上的元素为data，返回原值（此处为覆盖原来的值）
 * type ArrayList.get(int n);   得到ArrayList上下标为n的元素，返回这个值
 * int ArrayList.size();    得到ArrayList的长度，并返回
 * <p>
 * author:Benjamin
 */

public class TextArrayList {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        //不使用位置参数的添加,为尾添加
        one.add("zero");
        one.add("two");
        System.out.println(one);

        //使用位置参数，相当于数组的插入，较为耗费时间
        one.add(1, "one");
        System.out.println(one);

        //set设置某一位置上的值, 传入的int参数需已经设置了值
        one.set(1, "One");
        System.out.println(one);

        //使用下标随机读取
        System.out.println("one.get(2) = " + one.get(2));

        //ArrayList.size()返回容器的长度
        System.out.println("one.size() = " + one.size());


    }
}
