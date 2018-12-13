package textMultithread;

/**
 * 测试线程安全问题的解决
 * 两个顾客同时向银行中存钱，各存三次，每次100元
 * <p>
 * 线程安全问题可以有多种解决方法
 * 这里展示了使用synchronized进程锁和synchronized标记的方法分别解决问题
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
        for (int i = 0; i < 3; i++) {
//            进程锁
//            this.bank.add0(100);
//            进程锁定的方法
            this.bank.add1(100);
        }
    }
}
