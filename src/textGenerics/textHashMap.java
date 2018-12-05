package textGenerics;

import java.util.HashMap;

/**
 * ���Է��������е�HashMap
 * Map�൱��python�е��ֵ䣬��HashMap����ʹ�ù�ϣֵ��������˳����ֵ�
 * HashMap���Լ�ֵ�Ե���ʽ�洢Ԫ�أ�����ֵ�������κζ��󣨻�������Ӧ��װΪ��װ�� Integer�ȣ�
 * ��ͬ�ļ����Զ�Ӧ��ͬ��ֵ
 *
 * Object Map.put(Object key, Object value)    ��key-value����Map
 * Object Map.get(Object key)    ����Map�м�Ϊkey��ֵ��������
 * Object Map.remove(Object key)    ɾ��Map�м�Ϊkey��ֵ��������ԭֵ
 * boolean Map.containsKey(Object key)  ����Map���Ƿ����key�����
 * boolean Map.containsValue(Object value)  ����Map���Ƿ����value���ֵ
 * int Map.size()   ����Map�ڵ�Ԫ������
 * boolean Map.isEmpty()    �ж��Ƿ�Ϊ��
 * void Map.putAll(Map t)   ��Map t���Ƶ�Map�У�����Ӱ��Map��ԭ����Ԫ�أ�
 * void Map.clear()     ���Map
 *
 * HashMapʵ����Map�ӿڣ��������Ϸ���
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
        two.put(10, "ԭ������");
        System.out.println(two);
        two.putAll(one);
        System.out.println(two);
        two.clear();
        System.out.println(two);
    }
}
