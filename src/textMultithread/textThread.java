package textMultithread;

/**
 * 测试使用继承Thread类进行线程的创建
 *
 * 通过创建一个Thread类的子类来创建一个线程
 * 线程的任务放在该子类的run方法中，相当于主线程的main方法
 * 线程创建之后并不会运行，调用线程的run方法也不会启动线程
 * 需要调用子类的start方法启动线程
 * start方法会通知JVM（虚拟机）开启线程并在自定义的线程中执行run方法
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
        for(int i = 0; i < 1000; i++){
            System.out.println(this.getName() + "---" + i);
        }
    }
}

public class textThread {
    public static void main(String[] args) {
        // 创建线程，这时内存中并没有自定义的线程，只是已经定义好了
        // 在调用start方法之后，才会有三个线程（主线程、one、two）
        Thread1 one = new Thread1("one");
        Thread1 two = new Thread1("two");
        one.start();
        two.start();
    }
}
