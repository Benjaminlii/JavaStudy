package textMultithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ���ڲ���JDK1.5֮��������ԣ�Lock�ӿڼ�������
 * Lock�ӿ��ṩ����ʹ���߳��е��߳������߱��Ĺ��ܷ�װ�ɷ���
 * ��ͬ��������ͬ�������У����������ͽ���������ʽ�Ĺ��ܣ����������ܺܺõļ򻯱��
 * ���ǣ���JDK1.5֮��JDK�ṩ��Lock�ӿڡ�Condition�ӿ��Լ��������
 *
 * Lock��������Ա���Ϊ�����߳�������
 * �ö���ķ���ʵ�����߳�����������Lock.lock()���ͽ���(Lock.unlock())
 * ������������������˼ά
 *
 * Condition�ӿڽ��߳���Lock���̵߳Ĳ����������з�����ʵ�ֲ�ͬ�Ĺ���ʹ��ͬһ�����������Է�����ʹ�����ķ���
 * ������һ����Դ�������һ��Lock����һ��Lock���󱻷�Ϊ���ɸ�Condition���󣬾Ϳ���ʵ��һ���߳����Ķ���������򣨼�������
 * ���ң��ص��ǣ�����������ʵ�ֶ��������Ƶ��̵߳ķֱ����֮ǰ��synchronizedҪʵ�������Ĺ���ֻ�ܴ����������
 * Lock�ӿڵ���������newCondition������Lock.newCondition()�����Է���һ��Condition�ӿڵ��������
 * Condition�ӿڵ�             await()������signal()������signalAll()����
 * �ֱ��Ӧ��Object����������  wait()������notify()������notifyAll()����
 *
 * Ҫע����ǣ��������߳���Condition���а󶨣��������ڽ��е��߳̽���˯�ߣ�����Condition���б��
 * ����ʱ�����̵߳ı�ǽ��з�������
 *
 * �������Ϊһ���̵߳�����ĳһ��Condition��await()�������ͻ������ĸ�Condition����������˯��
 * ��ô����ʱҲ����ʹ�ø�Condition���������л���
 *
 * author:Benjamin
 * date:2018.12.17
 */
public class textLockAndCondition {
    public static void main(String[] args) {
        Resource1 one = new Resource1();

        Producer1 producer = new Producer1(one);
        Consumer1 customer = new Consumer1(one);

        Thread t0 = new Thread(producer);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(customer);
        Thread t3 = new Thread(customer);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}


// ��Դ��
class Resource1 {
    private String one = "";
    private int count = 0;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    private Condition producerCon = lock.newCondition();
    private Condition consumerCon = lock.newCondition();

    void set(String one) {
        lock.lock();
        try {
            while (this.flag) {
                try {
                    producerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.one = one + count++;
            System.out.println(Thread.currentThread().getName() + " ����----- " + this.one);
            this.flag = true;
            consumerCon.signalAll();
        }finally {
            // Ϊ�����ڳ���ִ�й����г����쳣�ն�ִ�ж�û���ͷ���
            // ����һ��Ҫʹ��try-catch-finally�������ͷŷ���finally��
            lock.unlock();
        }
    }

    synchronized void get() {
        lock.lock();
        try {
            while (!this.flag) {
                try {
                    consumerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " ����------- " + this.one);
            this.flag = false;
            producerCon.signalAll();
        }finally {
            lock.unlock();
        }
    }

}

// ������
class Producer1 implements Runnable {

    private Resource1 one;

    Producer1(Resource1 one) {
        this.one = one;
    }

    @Override
    public void run() {
        while(true) {
            one.set("��Ʒ");
        }
    }
}

// ������
class Consumer1 implements Runnable {

    private Resource1 one;

    Consumer1(Resource1 one) {
        this.one = one;
    }

    @Override
    public void run() {
        while(true) {
            one.get();
        }
    }
}



