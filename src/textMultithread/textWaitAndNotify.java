package textMultithread;

/**
 * ���ڲ���ʹ��wait������notify����ʵ���߳�֮���ͨ��
 * �����ͨ��ָ�����໥���ѣ�textCommun�ﲢ�������������ϵ�ͨ��
 *
 * wait()��notify()����Java��������Object��final����
 * ���wait()��notify()���ܱ����ǣ���Ȼ��Ҳû�б�Ҫȥ����
 * wait()��notify()Ӧ�����߳�����ͬ��������б�ʹ�ã�����������������Ӧ��ʱ�߳���������
 * ���ù��̣�
 *      ��ĳ���̵߳��߳����ڲ�������wait()����֮��
 *      �����ͷŸ��߳����������ĵ�ǰ�̵߳�cupִ��Ȩִ���ʸ���߳�����
 *      Ҳ��������˯���̣߳������ͷ��߳���
 *      ������һ�������У��ö����߳�����������notify()����������һ���������notifyAll()
 *      �Ƚ�˯�ߵ��̻߳��ѣ���������wait()��notify()�������߳�����ͬ���������ִ�е�
 *      ����notify()���̻߳��ڱ��������ձ����ѵ��̻߳��������߳����У����ܱ����ѣ����ǻ����޷�ִ�У��ȴ���ȡ�߳�����
 *      ������notify()���߳��˳�ͬ������֮���߳�������ʧ�������ѵ��̵߳�������
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
    // flagΪtrueʱд�룬Ϊfalseʱ��ȡ
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
            // ʹx��01֮���л�
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
