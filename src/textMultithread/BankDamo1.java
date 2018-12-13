package textMultithread;

/**
 * 测试线程安全问题的解决
 * 两个顾客同时向银行中存钱，各存100次，每次100元
 * <p>
 * 线程安全问题可以有多种解决方法
 * 这里展示了使用synchronized锁定同步代码块和synchronized标记的同步方法分别解决问题
 * 使用同步方法实际上也是使用了同步代码块，只不过隐式的使用了调用该方法的对象作为进程锁的对象进行标记
 * 如果想要同时使用两种方法解决线程安全问题，那么需要在同步代码块的参数栏传入this表示当前调用代码的对象
 * 调用过程（同步函数）：Thread（线程）对象调用了run方法，run方法调用了同步函数，所以this就代表当前的线程
 * 这只适用于run方法中没用调用其他对象的其他方法的情况下，因为this会改变
 * 总而言之：
 *      同步函数的obj是使用了当前进程的对象，同步代码块使用的obj是任意的
 *      如果想同时使用同步代码块和同步函数解决线程安全问题，需要保证两个obj对象相同
 *      并且建议使用同步代码块解决进程安全问题，因为同步函数是同步代码块的简写，会有一些问题
 *
 * 静态的同步函数所使用的进程锁对象是所属类的类对象（类也是对象）
 * <p>
 * author:Benjamin
 * date:2018.12.13
 */
public class BankDamo1 {
    public static void main(String[] args) {
        Customer one = new Customer();
        // 一个Customer对象分别使用两个线程来表示两个顾客分别存钱
        // 当然了，也可以使用两个Customer对象来别是两个顾客
        // 这样需要将Bank对象通过构造函数的参数传入
        Thread t1 = new Thread(one);
        Thread t2 = new Thread(one);
        t1.start();
        t2.start();
    }
}

class Bank {
    private int num = 0;
    private final Object obj = new Object();

    // 使用普通的进程锁来解决线程安全问题
    void add0(int num) {
        synchronized (obj) {
            this.num += num;
            System.out.println(Thread.currentThread().getName() + " -----> " + this.num);
        }
    }

    // 使用synchronized标记的函数来解决进程安全问题
    synchronized void add1(int num) {
        this.num += num;
        System.out.println(Thread.currentThread().getName() + " -----> " + this.num);
    }
}

class Customer implements Runnable {

    private Bank bank = new Bank();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            进程锁
            this.bank.add0(100);
//            进程锁定的方法
//            this.bank.add1(100);
        }
    }
}
