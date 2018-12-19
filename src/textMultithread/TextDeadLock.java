package textMultithread;

/**
 * 用于测试Java多线程的死锁
 * 死锁问题出现的原因是，两个线程各自占有一个线程锁，并且都想要进入另一个线程锁锁住的代码块
 * 这种情况多出现在线程锁同步代码块的嵌套（不同的对象！）
 * 那么在线程跳转时，线程锁会阻止线程跳转到另一个线程占有的代码中
 * 两个线程相互阻止，就出现了死锁
 *
 * 在本例中：
 *          线程0占有了线程锁obj  obj-->sleep(这时线程0得到了this)-->this(这一步就会出现锁死)
 *          线程1占有了线程锁this  this-->obj（obj已经被线程0占有，出现锁死）
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
        // 在线程0加载后睡眠主线程，使线程0进入分支
        // 然后改变flag的值，使线程1进入另一个分支
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
        // 这里单纯的为了演示死锁问题，代码无意义
        System.out.println(Thread.currentThread().getName() + "---" + DeadLock.flag);
        if (DeadLock.flag) {
            // 三层线程锁，第一层为obj，第二层为this,第三层为obj
            synchronized (obj) {
                // 在此睡眠，保证线程1得到线程锁obj
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doSomeThing();
            }
        }else{
            // 两层线程锁，第一层为this，第二层为obj
            doSomeThing();
        }
    }
}
