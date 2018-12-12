package textMultithread;

/**
 * 用于测试实现Runnable接口来实现多线程
 *
 * 创建类的对象，并且实现runnable接口，在Runnable接口的run方法中填充自定义线程要运行的代码
 * 创建Thread对象，并将Runnable接口的子类对象当作构造器的参数传入Thread对象（主要是得到run方法）
 * 这时线程就已经被创建
 * 调用start方法，启动线程
 * 可以通过Thread对象的方法来控制进程的状态
 *
 * 前一种使用Thread的子类实现多线程实际上是将Thread类中的run方法覆盖
 * 而如果使用传入Runnable接口的子类对象则实际上是将run方法传入到Thread对象中
 * Thread类的run函数源码：
 *      public void run() {
 *          if (target != null) {
 *              target.run();
 *          }
 *      }
 * target就是传入的Runnable对象，如果未传入target，那么就应该覆盖run方法
 *
 * 实现Runnable接口的好处：
 *      1、将多线程的实现与多线程执行的代码分离
 *      2、避免Java单继承的局限性
 * 这种方式实现多线程较为常见
 *
 * author:Benjamin
 * date:2018.12.12
 */
class doInOtherThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}

public class textRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new doInOtherThread());
        Thread t2 = new Thread(new doInOtherThread());
        t1.start();
        t2.start();
    }
}
