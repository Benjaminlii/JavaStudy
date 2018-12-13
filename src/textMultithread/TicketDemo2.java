package textMultithread;

/**
 * 测试多继承
 * 实现一个多个窗口同时卖票的程序
 * 第二种方法，使用四个线程同时运行一个对象的一个run方法
 *
 * 这里的方法线程并不安全
 *      如果在一个线程进入了if语句中时，CPU跳转去执行另一个线程并且改变了对象的状态
 *      使下一次会带这个线程的if语句中时并不满足其判断条件了，但是这里已经运行到了if语句中
 *      并不会再次进行条件判断，就会发生不可预知的错误
 *
 * author:Benjamin
 * date:2018.12.12
 */
public class TicketDemo2 {
    public static void main(String[] args) {
        Runnable r1 = new Ticket2();

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

class Ticket2 implements Runnable{
    // 票不能重复卖，所以四个Ticket对象共用一个num，及静态变量
    private int num = 100;

    private void sale() throws InterruptedException {
        // 保证票为正数
        while (this.num > 0) {
            // 延时
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName()
                    + "...." + num--);
        }
    }

    @Override
    public void run() {
        try {
            sale();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
