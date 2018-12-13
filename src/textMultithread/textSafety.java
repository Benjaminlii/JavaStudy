package textMultithread;

/**
 * ���ڲ�����������̰߳�ȫ����
 *
 * ʹ���߳�����һ�β����������ݵĴ�����������ʹ�߳������ڼ������̲߳��ܱ�����
 * ԭ��Ϊ��һ���߳̽���synchronized��Ĵ����ʱ��obj����ᱻ���
 * ��CPU�л��������߳�ʱ���߳̿�������ǵ�obj���ͻ�ִֹͣ�У����CPU�л�
 * ԭ�߳������α�CPU�л����Ѿ�����synchronized���Ĵ�����в���������֮��Ҳ����˵���߳����ή�ͳ������е�Ч�ʣ�
 * ���˳�synchronized�����ʱ���Ὣobj�ı�ǻ�ԭ��ʹ�������߳��л������synchronized���
 *
 * synchronized�߳�������̰߳�ȫ�����ǰ�᣺
 *      �ж���̣߳�������Щ�̶߳�ʹ����ͬһ���߳�����Ҳ���ǹ���һ��obj����
 *
 * author:Benjamin
 * date:2018.12.13
 */

public class textSafety {
    public static void main(String[] args) {
        Runnable r1 = new Ticket3();

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

// ���������֮ǰ������ͬ��ֻ������̰߳�ȫ�Ĵ���
class Ticket3 implements Runnable {
    // Ʊ�����ظ����������ĸ�Ticket������һ��num������̬����
    private int num = 100;
    private final Object obj = new Object();

    private void sale(){
        // ����������У����ܽ�run�����е����д��������������Ը�����ѭ���Ľṹ
        while (true) {
            // ����ʹ�����߳��������run��������Ҫ���������Ĵ����Ǳ���װ������
            // ��ô����ֱ���ڷ�װ�����ĺ��������ϼ���synchronized�ؼ���
            synchronized (obj) {
                // ��֤ƱΪ����
                if (this.num > 0) {
                    // ��ʱ
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...." + num--);
                }else{
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        sale();
    }
}
