package textMultithread;

/**
 * �����̰߳�ȫ����Ľ��
 * �����˿�ͬʱ�������д�Ǯ������100�Σ�ÿ��100Ԫ
 * <p>
 * �̰߳�ȫ��������ж��ֽ������
 * ����չʾ��ʹ��synchronized��������synchronized��ǵķ����ֱ�������
 * ʹ��ͬ������ʵ����Ҳ��ʹ�����߳�����ֻ������ʽ��ʹ���˵��ø÷����Ķ�����Ϊ�������Ķ�����б��
 * �����Ҫͬʱʹ�����ַ�������̰߳�ȫ���⣬��ô��Ҫ���߳����Ĳ���������this��ʾ��ǰ���ô���Ķ���
 * ���ù��̣�ͬ����������Thread���̣߳����������run������run����������ͬ������������this�ʹ�����ǰ���߳�
 * ��ֻ������run������û�õ��������������������������£���Ϊthis��ı�
 * �ܶ���֮�������ͬʱʹ���߳�����ͬ����������̰߳�ȫ���⣬��Ҫ��֤�����߳����Ķ�����ͬ
 * <p>
 * author:Benjamin
 * date:2018.12.13
 */
public class BankDamo1 {
    public static void main(String[] args) {
        Customer one = new Customer();
        // һ��Customer����ֱ�ʹ�������߳�����ʾ�����˿ͷֱ��Ǯ
        // ��Ȼ�ˣ�Ҳ����ʹ������Customer���������������˿�
        // ������Ҫ��Bank����ͨ�����캯���Ĳ�������
        Thread t1 = new Thread(one);
        Thread t2 = new Thread(one);
        t1.start();
        t2.start();
    }
}

class Bank {
    private int num = 0;
    private final Object obj = new Object();

    // ʹ����ͨ�Ľ�����������̰߳�ȫ����
    void add0(int num) {
        synchronized (obj) {
            this.num += num;
            System.out.println(Thread.currentThread().getName() + " -----> " + this.num);
        }
    }

    // ʹ��synchronized��ǵĺ�����������̰�ȫ����
    synchronized void add1(int num) {
        this.num += num;
        System.out.println(Thread.currentThread().getName() + " -----> " + this.num);
    }
}

class Customer implements Runnable {

    private Bank bank = new Bank();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            ������
            this.bank.add0(100);
//            ���������ķ���
//            this.bank.add1(100);
        }
    }
}