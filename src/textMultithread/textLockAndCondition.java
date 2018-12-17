package textMultithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于测试JDK1.5之后的新特性：Lock接口及其子类
 * Lock接口提供方法使多线程中的线程锁所具备的功能封装成方法
 * 在同步代码块和同步函数中，锁的上锁和解锁都是隐式的功能，则样并不能很好的简化编程
 * 于是，在JDK1.5之后，JDK提供了Lock接口、Condition接口以及相关子类
 *
 * Lock的子类可以被认为就是线程锁对象
 * 该对象的方法实现了线程锁的上锁（Lock.lock()）和解锁(Lock.unlock())
 * 这样更具有面向对象的思维
 *
 * Condition接口将线程锁Lock对线程的操作方法进行分区，实现不同的功能使用同一个锁，但可以分区域使用锁的方法
 * 这样，一个资源对象包含一个Lock对象，一个Lock对象被分为若干个Condition对象，就可以实现一个线程锁的多个操作区域（监视器）
 * 而且，重点是，这样做可以实现对锁所控制的线程的分别管理（之前的synchronized要实现这样的功能只能创建多个锁）
 * Lock接口的子类对象的newCondition方法（Lock.newCondition()）可以返回一个Condition接口的子类对象
 * Condition接口的             await()方法、signal()方法和signalAll()方法
 * 分别对应了Object类子类对象的  wait()方法、notify()方法和notifyAll()方法
 *
 * 要注意的是：并不是线程与Condition进行绑定，而是正在进行的线程进行睡眠，根据Condition进行标记
 * 唤醒时根据线程的标记进行分批唤醒
 *
 * 可以理解为一个线程调用了某一个Condition的await()方法，就会由锁的该Condition监视器尽行睡眠
 * 那么唤醒时也必须使用该Condition监视器进行唤醒
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


// 资源类
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
            System.out.println(Thread.currentThread().getName() + " 生产----- " + this.one);
            this.flag = true;
            consumerCon.signalAll();
        }finally {
            // 为避免在程序执行过程中出现异常终端执行而没有释放锁
            // 这里一定要使用try-catch-finally将所得释放放在finally中
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
            System.out.println(Thread.currentThread().getName() + " 消费------- " + this.one);
            this.flag = false;
            producerCon.signalAll();
        }finally {
            lock.unlock();
        }
    }

}

// 生产者
class Producer1 implements Runnable {

    private Resource1 one;

    Producer1(Resource1 one) {
        this.one = one;
    }

    @Override
    public void run() {
        while(true) {
            one.set("商品");
        }
    }
}

// 消费者
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



