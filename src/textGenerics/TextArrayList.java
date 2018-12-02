package textGenerics;

import java.util.ArrayList;

/**
 * ���Է��������е�ArrayList
 * ArrayList�൱�ڶ�̬���飬��ѯ�ٶȿ죬����ɾ���ٶ������̲߳���ȫ
 * <p>
 * ArrayList<type> name = new ArrayList<type>();    ����һ����������type��ArrayList���󣬺�һ���������е�type����ʡ��
 * �����������п��Լ��ϲ�����ָ����ʼ��Array List�Ĵ�С
 * boolean ArrayList.add(type data);    ��ArrayListβ�����Ԫ��data�������Ƿ���ӳɹ�
 * void ArrayList.add(int n, type data);    ��ArrayList�±�Ϊn��λ���ϲ���Ԫ��data���޷���ֵ
 * type ArrayList.set(int n, type data);    ����ArrayList�±�Ϊnλ���ϵ�Ԫ��Ϊdata������ԭֵ���˴�Ϊ����ԭ����ֵ��
 * type ArrayList.get(int n);   �õ�ArrayList���±�Ϊn��Ԫ�أ��������ֵ
 * int ArrayList.size();    �õ�ArrayList�ĳ��ȣ�������
 * <p>
 * author:Benjamin
 */

public class TextArrayList {
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();
        //��ʹ��λ�ò��������,Ϊβ���
        one.add("zero");
        one.add("two");
        System.out.println(one);

        //ʹ��λ�ò������൱������Ĳ��룬��Ϊ�ķ�ʱ��
        one.add(1, "one");
        System.out.println(one);

        //set����ĳһλ���ϵ�ֵ, �����int�������Ѿ�������ֵ
        one.set(1, "One");
        System.out.println(one);

        //ʹ���±������ȡ
        System.out.println("one.get(2) = " + one.get(2));

        //ArrayList.size()���������ĳ���
        System.out.println("one.size() = " + one.size());


    }
}
