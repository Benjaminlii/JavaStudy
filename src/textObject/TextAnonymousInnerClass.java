package textObject;

/**
 * ���ڲ��������ڲ���
 *
 * �����ڲ��࣬�ڷ�������ʱ��Ϊ�������뵽�����ڣ��ڷ����ڲ������ڲ����ĳЩ����
 * ��Ϊ�����Ե���ĳ���ĳ�з���������ͨ���Խӿ�Ϊģ��
 * �����ڣ���Ҫ���÷�����Ҫ���ò�����ĳ���ԣ�Ҳ���ǽ�����Ϊ�������룬���ڵ���ʱ����ʵ���ࣩ
 *
 * author:Benjamin
 */

public class TextAnonymousInnerClass {
    private static void doIt(someOne one){
        one.toDoSomething();
    }

    public static void main(String[] args) {
//        �������ʹ��ū���ڲ��࣬����ʹ��lambda���ʽ���������ڲ���
        TextAnonymousInnerClass.doIt(new someOne() {
            @Override
            public void toDoSomething() {
                System.out.println("do it by anonymous inner class");
            }
        });
    }
}

interface someOne{
    void toDoSomething();
}
