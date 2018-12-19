package textMultithread;

/**
 * 测试多线程中的经典案例：生产者消费者案例
 * 这个案例和之前的多线程之间通过wait()和notify()进行通信基本一样
 * 但是如果出现了多生产者和多消费者，就会由于线程唤醒的随机性出现一系列问题
 *
 * 原版的if（）{wait} + notify（）在遇到多个生产者和多个消费者就会出现线程安全问题
 *      现在有四个线程，两个负责生产，两个负责消费
 *      当睡眠了三个线程之后，如果被唤醒的下一个线程跟正在执行的线程是同种任务的线程
 *      就会将一个任务同时执行两遍
 *      主要原因是，在睡眠之前已经进行过了if()判断，当睡眠之后运行的线程改变了flag的状态
 *      原本因该使同种的线程进行睡眠，但是由于线程的唤醒使在if判断之后继续运行代码
 *      所以导致不满足if的条件下执行了相关代码
 *      于是就重复执行了某一操作
 *
 * 要解决if不能再次进行判断的问题，可以将if判断替换成while进行循环判断并执行wait（）
 *      但这样又会出现线程死锁的问题
 *      原因还是一样，唤醒了与运行中线程同样任务的线程
 *      但这次由于使while循环判断执行wait（），并且循行中线程改变了flag的状态
 *      导致唤醒之后，两个线程都被while判定进行wait（）
 *      四个线程都被睡眠，出现线程死锁
 *
 *  这时根本问题就在于唤醒线程的随机性，那么要使不同任务的线程要被唤醒就可以考虑使用notifyAll()
 *
 * 最总的解决方案使将if替换成while，并且使用notifyAll()代替notify()
 *      while解决了唤醒后线程不进行判断直接运行的问题
 *      notifyAll()唤醒了所有的线程，其中肯定包括与运行线程（将要被锁定）不同任务的线程
 *      这样就解决了会出现四个睡眠线程的问题
 *
 * 至此，多生产者多消费者案例被解决，但这样的解决方案是有缺陷的
 * 程序线程唤醒和睡眠的次数非常多，也就导致运行的效率低下
 *
 *
 *  author:Benjamin
 * date:2018.12.15
 */
public class TextProducerAndConsumer {
    public static void main(String[] args) {
        Resource one = new Resource();

        Producer producer = new Producer(one);
        Consumer customer = new Consumer(one);

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
class Resource {
    private String one = "";
    private int count = 0;
    private boolean flag = false;

    synchronized void set(String one) {
        while(this.flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.one = one + count++;
        System.out.println(Thread.currentThread().getName() + " 生产----- " + this.one);

        this.flag = true;
        this.notifyAll();
    }

    synchronized void get() {
        while(!this.flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 消费------- " + this.one);

        this.flag = false;
        this.notifyAll();
    }

}

// 生产者
class Producer implements Runnable {

    private Resource one;

    Producer(Resource one) {
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
class Consumer implements Runnable {

    private Resource one;

    Consumer(Resource one) {
        this.one = one;
    }

    @Override
    public void run() {
       while(true) {
           one.get();
       }
    }
}


