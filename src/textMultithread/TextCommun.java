package textMultithread;

/**
 * 测试多线程之间的通讯问题
 * 注意处理线程安全问题
 * <p>
 * Data类存放一些属性
 * Input类的对象设置Data类的属性
 * Output类的对象输出Data类的属性
 *
 * 要注意的是：
 *      要出现多线程之间的通讯，那么肯定要有共享的数据
 *      那么就要使用线程锁来保证线程的安全
 *      而且多个方法（多个线程运行不同的方法）要使用同一个线程锁
 *      这里现成的线程锁就是共享数据对象本身
 * <p>
 * author:Benjamin
 * date:2018.12.14
 */
public class TextCommun {
    public static void main(String[] args) {
        DataForCommun one = new DataForCommun();

        Input in = new Input(one);
        Output out = new Output(one);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }
}

class DataForCommun {
    String data1;
    String data2;
}

class Input implements Runnable {
    private final DataForCommun one;

    public Input(DataForCommun one) {
        this.one = one;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (one) {
                if (x == 0) {
                    one.data1 = "----";
                    one.data2 = "----";
                } else {
                    one.data1 = "++++";
                    one.data2 = "++++";
                }
            }
            // 使x在01之间切换
            x = (x + 1) % 2;
        }
    }
}

class Output implements Runnable{
    private final DataForCommun one;

    public Output(DataForCommun one) {
        this.one = one;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (one) {
                System.out.println(one.data1 + one.data2);
            }
        }
    }
}
