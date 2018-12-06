package textGenerics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试迭代器 Iterator，所以严格意义上将并不属于泛型类，但大多搭配使用，所以放在这里
 * Iterator是一个接口，实现了这个接口的类都可以使用util包中的Iterator迭代器
 * 迭代器相当于在C语言中for循环遍历数组的一个封装
 * 好处在于使用迭代器可以不需要知道类型，这非常适合在对泛型容器遍历时使用
 * for循环一般用于简单集合的遍历
 * foreach循环需要知道遍历的元素类型
 * 迭代器不需要知道对象的类型，不需要知道大小，而且可以随时通过remove修改所遍历的容器
 * boolean Iterator.hasNext()   判断是否还能继续遍历
 * object Iterator.next()   向后遍历一个元素，将指针向后移动一个元素，并且将遍历到的元素返回
 * void Iterator.remove()   删除遍历到的最后一个元素
 *                          建议再遍历时使用Iterator的remove而不是Collection接口的remove
 *                          原因是：Iterator的remove比较安全，在删除元素之后会同时更新集合对象与Iterator对象的元素关系
 *                                  而如果使用Collection的remove，Iterator对象不会被改变，继续遍历就可能会出错
 * author:Benjamin
 * date:2018.12.6
 */
public class textIterator {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            one.add("" + i);
        }
        System.out.println("one = " + one);
        System.out.print("one(by Iterator) = ");

//        for循环占用内存更少（局部变量）
//        for (Iterator<String> forOne = one.iterator(); forOne.hasNext(); ) {
//            String oneData = forOne.next();
//            System.out.print(oneData + ",");
//        }
        Iterator<String> forOne = one.iterator();
        while(forOne.hasNext()){
            String s = forOne.next();
            System.out.print(s + ",");
        }

        //使用Iterator的remove删除集合中的元素
        forOne = one.iterator();
        while(forOne.hasNext()){
//            如果遍历到"5"则删除最新遍历到的元素
            if(forOne.next().equals("5")){
                System.out.println("\nremove \"5\"");
                forOne.remove();
            }
        }
        System.out.println(one);

    }
}
