package textMultithread;

/**
 * ���ڲ���ʹ��wait������notify����ʵ���߳�֮���ͨ��
 * �����ͨ��ָ�����໥���ѣ�textCommun�ﲢ�������������ϵ�ͨ��
 * <p>
 * wait()��notify()����Java��������Object��final����
 * ���wait()��notify()���ܱ����ǣ���Ȼ��Ҳû�б�Ҫȥ����
 * wait()��notify()Ӧ�����߳�����ͬ��������б�ʹ�ã�����������������Ӧ��ʱ�߳���������
 * ���ù��̣�
 * ��ĳ���̵߳��߳����ڲ�������wait()����֮��
 * �����ͷŸ��߳����������ĵ�ǰ�̵߳�cupִ��Ȩִ���ʸ���߳�����
 * Ҳ��������˯���̣߳������ͷ��߳���
 * ������һ�������У��ö����߳�����������notify()����������һ���������notifyAll()
 * �Ƚ�˯�ߵ��̻߳��ѣ���������wait()��notify()�������߳�����ͬ���������ִ�е�
 * ����notify()���̻߳��ڱ��������ձ����ѵ��̻߳��������߳����У����ܱ����ѣ����ǻ����޷�ִ�У��ȴ���ȡ�߳�����
 * ������notify()���߳��˳�ͬ������֮���߳�������ʧ�������ѵ��̵߳�������
 * <p>
 * �����Ż��������̵߳Ĳ�����������Դ���н��У���Ϊ��Դ�౾����Ǻܺõ��߳���
 * ��Σ�����Դ���У�����ͬͬʱʹ��ͬ��������ͬ������飨�߳�������this��
 * <p>
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
    private String data1;
    private String data2;
    // flagΪtrueʱд�룬Ϊfalseʱ��ȡ
    private boolean flag = false;

    synchronized void set(String data1, String data2) {
        if (this.flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.data1 = data1;
        this.data2 = data2;

        this.flag = true;
        this.notify();
    }

    synchronized void get() {
        if (!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(data1 + data2);

        this.flag = false;
        this.notify();

    }
}

class Input1 implements Runnable {
    private final DataForCommun1 one;

    Input1(DataForCommun1 one) {
        this.one = one;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            if (x == 0) this.one.set("----", "----");
            else this.one.set("++++", "++++");
            // ʹx��01֮���л�
            x = (x + 1) % 2;
        }
    }
}

class Output1 implements Runnable {
    private final DataForCommun1 one;

    Output1(DataForCommun1 one) {
        this.one = one;
    }

    @Override
    public void run() {
        while (true)
            this.one.get();
    }
}
