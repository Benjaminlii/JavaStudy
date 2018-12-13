package textMultithread;

/**
 * ���Զ�̳�
 * ʵ��һ���������ͬʱ��Ʊ�ĳ���
 * �ڶ��ַ�����ʹ���ĸ��߳�ͬʱ����һ�������һ��run����
 *
 * ����ķ����̲߳�����ȫ
 *      �����һ���߳̽�����if�����ʱ��CPU��תȥִ����һ���̲߳��Ҹı��˶����״̬
 *      ʹ��һ�λ������̵߳�if�����ʱ�����������ж������ˣ����������Ѿ����е���if�����
 *      �������ٴν��������жϣ��ͻᷢ������Ԥ֪�Ĵ���
 *
 * author:Benjamin
 * date:2018.12.12
 */
public class TicketDemo2 {
    public static void main(String[] args) {
        Runnable r1 = new Ticket2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Ticket2 implements Runnable{
    // Ʊ�����ظ����������ĸ�Ticket������һ��num������̬����
    private int num = 100;

    private void sale() throws InterruptedException {
        // ��֤ƱΪ����
        while (this.num > 0) {
            // ��ʱ
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName()
                    + "...." + num--);
        }
    }

    @Override
    public void run() {
        try {
            sale();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
