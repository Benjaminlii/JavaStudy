package JavaSE.textMultithread;

/**
 * 测试多继承
 * 实现一个多个窗口同时卖票的程序
 * 这是第一种方法，将票数静态化，使得四个进程操作一个num
 * 这种方法也可以使用Thread子类的方式实现多继承
 * 该方法有较大的局限性，例如：四个窗口只能同时卖一种票等
 *
 * author:Benjamin
 * date:2018.12.12
 */
class Ticket1 implements Runnable{
    // 票不能重复卖，所以四个Ticket对象共用一个num，及静态变量
    private static int num = 100;

    private void sale() {
        // 保证票为正数
        while (Ticket1.num > 0) {
            // 延时
            for(int i = 0; i < 1000000; i++);
            System.out.println(Thread.currentThread().getName()
                    + "...." + num--);
        }
    }

    @Override
    public void run() {
        sale();
    }
}

public class TicketDemo1{
    public static void main(String[] args) {
        Runnable r1 = new Ticket1();
        Runnable r2 = new Ticket1();
        Runnable r3 = new Ticket1();
        Runnable r4 = new Ticket1();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
