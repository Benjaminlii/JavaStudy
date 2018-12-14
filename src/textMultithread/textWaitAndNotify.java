package textMultithread;

/**
 * 用于测试使用wait（）和notify（）实现线程之间的通信
 * 这里的通信指的是相互唤醒，textCommun里并不是真正意义上的通信
 *
 * wait()和notify()都是Java顶级父类Object的final方法
 * 因此wait()和notify()不能被覆盖，当然了也没有必要去覆盖
 * wait()和notify()应该在线程锁的同步代码块中被使用，调用这两个方法的应该时线程锁对象本身
 * 调用过程：
 *      在某个线程的线程锁内部调用了wait()方法之后
 *      立即释放该线程锁所锁定的当前线程的cup执行权执行资格和线程锁定
 *      也就是立即睡眠线程，并且释放线程锁
 *      当在另一处代码中，该对象（线程锁）调用了notify()或者有任意一对象调用了notifyAll()
 *      先将睡眠的线程唤醒，但是由于wait()和notify()都是在线程锁的同步代码块中执行的
 *      调用notify()的线程还在被锁定，刚被唤醒的线程还运行在线程锁中，尽管被唤醒，但是还是无法执行（等待获取线程锁）
 *      当调用notify()的线程退出同步语句块之后，线程锁定消失，被唤醒的线程得以运行
 *
 * author:Benjamin
 * date:2018.12.14
 */
public class textWaitAndNotify {
    public static void main(String[] args) {
        DataForCommun1 one = new DataForCommun1();

        Input1 in = new Input1(one);
        Output1 out = new Output1(one);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }
}

class DataForCommun1 {
    String data1;
    String data2;
    // flag为true时写入，为false时读取
    boolean flag = false;
}

class Input1 implements Runnable {
    private final DataForCommun1 one;

    public Input1(DataForCommun1 one) {
        this.one = one;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (one) {
                if(!one.flag){
                    try {
                        one.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x == 0) {
                    one.data1 = "----";
                    one.data2 = "----";
                } else {
                    one.data1 = "++++";
                    one.data2 = "++++";
                }
                x = (x + 1) % 2;
                 one.flag = false;
                 one.notify();
            }
            // 使x在01之间切换
        }
    }
}

class Output1 implements Runnable{
    private final DataForCommun1 one;

    public Output1(DataForCommun1 one) {
        this.one = one;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (one) {
                if(one.flag){
                    try {
                        one.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(one.data1 + one.data2);
                one.flag = true;
                one.notify();
            }
        }
    }
}
