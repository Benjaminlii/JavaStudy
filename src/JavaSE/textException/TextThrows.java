package JavaSE.textException;

/**
 * ����throws�׳������еĴ���
 *
 * �ڷ����п��ܻ���ֵ��쳣�����ǿ��Բ�ȡ���ֽ������
 * һ�����ڷ�������֮��ʹ��throws���ô����׳��������ͱ����ڵ���ʱʹ��try-catch�����д���
 * ��һ����ֱ���ڷ������ڲ�ʹ��try-catch����
 * һ�㶼���ڵ��õĸ߲㴦�����쳣
 *
 * date:2018.12.1
 * author:Benjamin
 */

public class TextThrows {
    private static void doIt() throws ArithmeticException {
//        ���дһ�������������Գ���Ϊ��
//        ʵ���ϣ���������ʱ�Żᷢ�ֵĴ���Ӧ����if������ų�
        int a = 1;
        int b = 0;
        if(b == 0){
//            �׳����쳣������һ�����󣬶�����һ���࣬��Ҫʵ����
//            �����׳��쳣��ָ�������ñ�������Ҫtry-catch������
            throw new ArithmeticException("'b'should't equals to Zero.");
        }
        double answer = a / b;
        System.out.println(answer);
    }

    public static void main(String[] args) {
//      �������doIt�����������ͱ�������쳣�Ĵ���
        try {
            doIt();
        } catch (ArithmeticException e) {
//            ����һ��ѡ������쳣����Ϣ���൱�ڱ���
            System.out.println("there has a Exception.");
            e.printStackTrace();
        }

    }
}