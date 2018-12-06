package textGenerics;

import java.util.HashSet;

/**
 * 测试泛型容器中的HashSet
 * HashSet相当于集合，是一种存储的数据之间没有顺序的泛型容器类
 * HashSet使用哈希值安排数据的顺序，并没有实际意义上的顺序
 *
 * boolean HashSet.add(Object value)    将值value存入HashSet，在HashSet内部，元素与元素之间不能重复，重复添加会添加失败
 * boolean HashSet.remove(Object value)    在HashSet中删除值value，返回true，如果不存在返回false
 * int HashSet.size()   返回HashSet内元素的数量
 * boolean HashSet.contains(Object value)    HashSet中是否存在值value
 * boolean HashSet.isEmpty()    判空
 * void HashSet.clear()     清空HashSet
 * Array HashSet.toArray()  将HashSet转化为数组并返回
 *
 * author:Benjamin
 * date:2018.12.5
 */

public class textHashSet {
    public static void main(String[] args) {
        HashSet<String> one = new HashSet<>();
        one.add("one");
        one.add("two");
        one.add("three");
        one.add("two"); //重复添加不会成功
        System.out.println(one);
        one.remove("two");
        System.out.println(one);
        System.out.println("one.contains('zero') = " + one.contains("zero"));
        System.out.println("one.isEmpty() = " + one.isEmpty());
        System.out.println("one.size() = " + one.size());
        System.out.println("one.toArray() = " + one.toArray());
        one.clear();
        System.out.println(one);
    }
}
