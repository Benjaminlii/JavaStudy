package textMultithread;

/**
 * 测试使用继承Thread类进行线程的创建
 *
 * 通过创建一个Thread类的子类来创建一个线程，并且覆盖Thread类的run方法
 * 线程的任务放在该子类的run方法中，相当于主线程的main方法
 * 线程创建之后并不会运行，调用线程的run方法也不会启动线程
 * 需要调用子类的start方法启动线程
 * start方法会通知JVM（虚拟机）开启线程并在自定义的线程中执行run方法
 *
 * 在多线程中，异常只会影响其所属的线程，其他线程的进行不受影响
 * 关于线程的状态：
 *      线程的状态大致分为被创建、运行、睡眠、临时阻塞、死亡
 *      Thread类的子类一经实例化，进程就被创建了
 *      调用该子类的start方法之后，该进程变为运行状态
 *      正在运行的进程可以通过sleep（time）方法进行睡眠，time为整型参数，意义为睡眠的时间，单位为毫秒
 *      在time时间过后，进程自动转换为运行状态
 *      也可以通过wait（等待）方法和notify（唤醒）方法在运行和睡眠两种状态之间转换
 *      正在运行的进程由于CPU的随机执行（同一时间，CPU只能执行一个进程，而由于CPU在进行快速的切换，所以给人的感觉就是同时执行）
 *      要运行的进程总是有一个正在被执行，其他的进程在排队，这个排队的状态就是临时阻塞
 *      临时阻塞状态的进程有CPU的执行资格，但是没有执行权，正在等待CPU资源的分配
 *      睡眠状态的进程没有CPU的执行权也没有执行资格，唤醒后重新得到执行权也没有执行资格
 *      而当进程的run方法运行结束，或者调用了stop方法（已过时）之后，进程就会死亡
 *
 * 看样子我电脑CPU跑的还挺快
 *
 * author:Benjamin
 * date:2018.12.12
 */

class Thread1 extends Thread{
    Thread1(String name) {
        super(name);
    }

    // run方法承载了自定义线程中要运行的代码
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            // 通过Thread.getName()方法可以得到线程的名称，默认为 Thread-0,1,2,3....
            // currentThread()方法可以返回当前正在进行的线程的对象，而Thread.getName()得到的不一定是正在运行的对象的名字
            // 如：调用run（）在主线程调用原本应该在自定义线程中运行的代码，这是Thread.getName()得到的时自定义的线程名
            // 而正在运行的是主线程
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}

public class textThread {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程，这时内存中并没有自定义的线程，只是已经定义好了
        // 在调用start方法之后，才会有三个线程（主线程、one、two）
        Thread1 one = new Thread1("one");
        Thread1 two = new Thread1("two");
        one.start();
        two.start();
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
            // 睡眠5000毫秒，也就是5秒
            if(i == 50) Thread.sleep(5000);
        }
    }
}
