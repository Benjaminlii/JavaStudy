package textGenerics;

import java.util.HashSet;

/**
 * ���Է��������е�HashSet
 * HashSet�൱�ڼ��ϣ���һ�ִ洢������֮��û��˳��ķ���������
 * HashSetʹ�ù�ϣֵ�������ݵ�˳�򣬲�û��ʵ�������ϵ�˳��
 *
 * boolean HashSet.add(Object value)    ��ֵvalue����HashSet����HashSet�ڲ���Ԫ����Ԫ��֮�䲻���ظ����ظ���ӻ����ʧ��
 * boolean HashSet.remove(Object value)    ��HashSet��ɾ��ֵvalue������true����������ڷ���false
 * int HashSet.size()   ����HashSet��Ԫ�ص�����
 * boolean HashSet.contains(Object value)    HashSet���Ƿ����ֵvalue
 * boolean HashSet.isEmpty()    �п�
 * void HashSet.clear()     ���HashSet
 * Array HashSet.toArray()  ��HashSetת��Ϊ���鲢����
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
        one.add("two"); //�ظ���Ӳ���ɹ�
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
