package textMultithread;

/**
 * 用于测试怎样解决线程安全问题
 *
 * 使用线程锁将一段操作共享数据的代码锁起来，使线程运行期间其他线程不能被运行
 * 原理为，一个线程进入synchronized后的代码块时，obj对象会被标记
 * 当CPU切换到其他线程时，线程看到被标记的obj，就会停止执行，随后被CPU切换
 * 原线程在数次被CPU切换到已经进入synchronized语句的代码块中并且运行完之后（也就是说，线程锁会降低程序运行的效率）
 * 在退出synchronized代码块时，会将obj的标记还原，使得其他线程有机会进入synchronized语句
 *
 * synchronized线程锁解决线程安全问题的前提：
 *      有多个线程，并且这些线程都使用了同一个线程锁，也就是共用一个obj对象
 *
 * author:Benjamin
 * date:2018.12.13
 */

public class textSafety {
    public static void main(String[] args) {
        Runnable r1 = new Ticket3();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

// 这里的类与之前的类相同，只添加了线程安全的处理
class Ticket3 implements Runnable {
    // 票不能重复卖，所以四个Ticket对象共用一个num，及静态变量
    private int num = 100;
    private final Object obj = new Object();

    private void sale(){
        // 在这个例子中，不能将run方法中的所有代码锁起来，所以更改了循环的结构
        while (true) {
            // 这里使用了线程锁，如果run方法中需要被锁起来的代码是被封装起来的
            // 那么可以直接在封装函数的函数定义上加上synchronized关键字
            synchronized (obj) {
                // 保证票为正数
                if (this.num > 0) {
                    // 延时
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...." + num--);
                }else{
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        sale();
    }
}
