package textMultithread;

/**
 * ���ڲ���Java���̵߳�����
 * ����������ֵ�ԭ���ǣ������̸߳���ռ��һ���߳��������Ҷ���Ҫ������һ���߳�����ס�Ĵ����
 * ���������������߳���ͬ��������Ƕ�ף���ͬ�Ķ��󣡣�
 * ��ô���߳���תʱ���߳�������ֹ�߳���ת����һ���߳�ռ�еĴ�����
 * �����߳��໥��ֹ���ͳ���������
 *
 * �ڱ����У�
 *          �߳�0ռ�����߳���obj  obj-->sleep(��ʱ�߳�0�õ���this)-->this(��һ���ͻ��������)
 *          �߳�1ռ�����߳���this  this-->obj��obj�Ѿ����߳�0ռ�У�����������
 * <p>
 * author:Benjamin
 * date:2018.12.14
 */
public class TextDeadLock {
    public static void main(String[] args) {
        Runnable one = new DeadLock();

        Thread t1 = new Thread(one);
        Thread t2 = new Thread(one);

        t1.start();
        // ���߳�0���غ�˯�����̣߳�ʹ�߳�0�����֧
        // Ȼ��ı�flag��ֵ��ʹ�߳�1������һ����֧
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DeadLock.flag = false;
        t2.start();
    }
}

class DeadLock implements Runnable {
    private final static Object obj = new Object();
    static boolean flag = true;

    private synchronized void doSomeThing() {
        synchronized (obj) {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
            }
        }
    }

    @Override
    public void run() {
        // ���ﵥ����Ϊ����ʾ�������⣬����������
        System.out.println(Thread.currentThread().getName() + "---" + DeadLock.flag);
        if (DeadLock.flag) {
            // �����߳�������һ��Ϊobj���ڶ���Ϊthis,������Ϊobj
            synchronized (obj) {
                // �ڴ�˯�ߣ���֤�߳�1�õ��߳���obj
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doSomeThing();
            }
        }else{
            // �����߳�������һ��Ϊthis���ڶ���Ϊobj
            doSomeThing();
        }
    }
}
