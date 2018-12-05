package textGenerics;

import java.util.HashMap;

/**
 * 测试泛型容器中的HashMap
 * Map相当于python中的字典，而HashMap就是使用哈希值计算排列顺序的字典
 * HashMap中以键值对的形式存储元素，键和值可以是任何对象（基本类型应包装为包装类 Integer等）
 * 不同的键可以对应相同的值
 *
 * Object Map.put(Object key, Object value)    将key-value存入Map
 * Object Map.get(Object key)    查找Map中键为key的值，并返回
 * Object Map.remove(Object key)    删除Map中键为key的值，并返回原值
 * boolean Map.containsKey(Object key)  查找Map中是否存在key这个键
 * boolean Map.containsValue(Object value)  查找Map中是否存在value这个值
 * int Map.size()   返回Map内的元素数量
 * boolean Map.isEmpty()    判断是否为空
 * void Map.putAll(Map t)   将Map t复制到Map中（并不影响Map中原来的元素）
 * void Map.clear()     清空Map
 *
 * HashMap实现了Map接口，包含以上方法
 *
 * author:Benjamin
 */

public class textHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> one = new HashMap<>();
        one.put(1, "one");
        one.put(2, "two");
        one.put(3, "three");
        one.put(4, "one");
        System.out.println(one);
        System.out.println("one.get(1) = " + one.get(1));
        one.remove(4);
        System.out.println(one);
        System.out.println("one.containsKey(3) = " + one.containsKey(3));
        System.out.println("one.containsValue('3') = " + one.containsValue("3"));
        System.out.println("one.size() = " + one.size());
        System.out.println("one.isEmpty() = " + one.isEmpty());

        HashMap<Integer, String> two = new HashMap<>();
        two.put(10, "原有数据");
        System.out.println(two);
        two.putAll(one);
        System.out.println(two);
        two.clear();
        System.out.println(two);
    }
}
