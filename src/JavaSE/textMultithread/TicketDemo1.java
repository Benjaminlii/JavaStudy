package JavaSE.textMultithread;

/**
 * ���Զ�̳�
 * ʵ��һ���������ͬʱ��Ʊ�ĳ���
 * ���ǵ�һ�ַ�������Ʊ����̬����ʹ���ĸ����̲���һ��num
 * ���ַ���Ҳ����ʹ��Thread����ķ�ʽʵ�ֶ�̳�
 * �÷����нϴ�ľ����ԣ����磺�ĸ�����ֻ��ͬʱ��һ��Ʊ��
 *
 * author:Benjamin
 * date:2018.12.12
 */
class Ticket1 implements Runnable{
    // Ʊ�����ظ����������ĸ�Ticket������һ��num������̬����
    private static int num = 100;

    private void sale() {
        // ��֤ƱΪ����
        while (Ticket1.num > 0) {
            // ��ʱ
            for(int i = 0; i < 1000000; i++);
            System.out.println(Thread.currentThread().getName()
                    + "...." + num--);
        }
    }

    @Override
    public void run() {
        sale();
    }
}

public class TicketDemo1{
    public static void main(String[] args) {
        Runnable r1 = new Ticket1();
        Runnable r2 = new Ticket1();
        Runnable r3 = new Ticket1();
        Runnable r4 = new Ticket1();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
