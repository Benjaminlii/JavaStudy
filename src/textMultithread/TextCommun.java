package textMultithread;

/**
 * ���Զ��߳�֮���ͨѶ����
 * ע�⴦���̰߳�ȫ����
 * <p>
 * Data����һЩ����
 * Input��Ķ�������Data�������
 * Output��Ķ������Data�������
 *
 * Ҫע����ǣ�
 *      Ҫ���ֶ��߳�֮���ͨѶ����ô�϶�Ҫ�й��������
 *      ��ô��Ҫʹ���߳�������֤�̵߳İ�ȫ
 *      ���Ҷ������������߳����в�ͬ�ķ�����Ҫʹ��ͬһ���߳���
 *      �����ֳɵ��߳������ǹ������ݶ�����
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
            // ʹx��01֮���л�
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
