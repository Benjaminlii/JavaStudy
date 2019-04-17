package JavaSE.textReflect;

import java.lang.reflect.Modifier;

/**
 * ��ʼѧϰ����
 * <p>
 * author:Benjamin
 * date:2019.3.31
 */

public class TextClass {
    public static void main(String[] args) throws ClassNotFoundException {
        methor_1();
    }

    /**
     * �õ�ĳ�����Class��������ַ���
     * 1��ÿ������ڲ������ɾ�̬�����ԣ�Ϊ�����Class�����
     * 2���Ը����ĳһ��ʵ��������ʹ��getClass�����������Եõ������Class����
     * 3��ͨ��Class.forName(String s)����
     * ������һ���ַ����ڵ�ǰĿ¼���ҵ��ַ�����Ӧ��.class�ļ����Ӷ��õ��ַ�����Ӧ��Class����
     * <p>
     * �������й����У�����ǰ�����࣬��ֻ���ڽ��е�һ��ʵ����ʱ���Ż������ĳ�ʼ����1��2���ַ����������ʼ�������3��
     *
     * @throws ClassNotFoundException
     */
    public static void methor_0() throws ClassNotFoundException {
        Class c1 = Person.class;
        System.out.println("Person.class");

        Class c2 = (new Person()).getClass();
        System.out.println("(new Person()).getClass()");

        Class c3 = Class.forName("JavaSE.textReflect.Person"); // ������Ҫ��������������.������
        System.out.println("Class.forName(\"Person\")");

        System.out.println("if c1==c2==c3 : " + (c1 == c2 & c2 == c3));
    }

    public static void methor_1() throws ClassNotFoundException {
        //���Class����
        Class one = String.class;

        //������η�
        //Class.getModifiers()���ش������������Ϣ��int
        // Modifier��Ϊ������Ϣ�࣬toString()����������intתString
        System.out.println(Modifier.toString(one.getModifiers()));

        //����
        System.out.println("class : (" + one.getName() + ") or (" + one.getSimpleName() + ")");

        //����
        System.out.println("superClass : " + one.getSuperclass());

        //�ӿ�
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