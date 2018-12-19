package textMultithread;

/**
 * ���Զ��߳��еľ��䰸���������������߰���
 * ���������֮ǰ�Ķ��߳�֮��ͨ��wait()��notify()����ͨ�Ż���һ��
 * ������������˶������ߺͶ������ߣ��ͻ������̻߳��ѵ�����Գ���һϵ������
 *
 * ԭ���if����{wait} + notify������������������ߺͶ�������߾ͻ�����̰߳�ȫ����
 *      �������ĸ��̣߳���������������������������
 *      ��˯���������߳�֮����������ѵ���һ���̸߳�����ִ�е��߳���ͬ��������߳�
 *      �ͻὫһ������ͬʱִ������
 *      ��Ҫԭ���ǣ���˯��֮ǰ�Ѿ����й���if()�жϣ���˯��֮�����е��̸߳ı���flag��״̬
 *      ԭ�����ʹͬ�ֵ��߳̽���˯�ߣ����������̵߳Ļ���ʹ��if�ж�֮��������д���
 *      ���Ե��²�����if��������ִ������ش���
 *      ���Ǿ��ظ�ִ����ĳһ����
 *
 * Ҫ���if�����ٴν����жϵ����⣬���Խ�if�ж��滻��while����ѭ���жϲ�ִ��wait����
 *      �������ֻ�����߳�����������
 *      ԭ����һ�������������������߳�ͬ��������߳�
 *      ���������ʹwhileѭ���ж�ִ��wait����������ѭ�����̸߳ı���flag��״̬
 *      ���»���֮�������̶߳���while�ж�����wait����
 *      �ĸ��̶߳���˯�ߣ������߳�����
 *
 *  ��ʱ������������ڻ����̵߳�����ԣ���ôҪʹ��ͬ������߳�Ҫ�����ѾͿ��Կ���ʹ��notifyAll()
 *
 * ���ܵĽ������ʹ��if�滻��while������ʹ��notifyAll()����notify()
 *      while����˻��Ѻ��̲߳������ж�ֱ�����е�����
 *      notifyAll()���������е��̣߳����п϶������������̣߳���Ҫ����������ͬ������߳�
 *      �����ͽ���˻�����ĸ�˯���̵߳�����
 *
 * ���ˣ��������߶������߰�����������������Ľ����������ȱ�ݵ�
 * �����̻߳��Ѻ�˯�ߵĴ����ǳ��࣬Ҳ�͵������е�Ч�ʵ���
 *
 *
 *  author:Benjamin
 * date:2018.12.15
 */
public class TextProducerAndConsumer {
    public static void main(String[] args) {
        Resource one = new Resource();

        Producer producer = new Producer(one);
        Consumer customer = new Consumer(one);

        Thread t0 = new Thread(producer);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(customer);
        Thread t3 = new Thread(customer);

        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}

// ��Դ��
class Resource {
    private String one = "";
    private int count = 0;
    private boolean flag = false;

    synchronized void set(String one) {
        while(this.flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.one = one + count++;
        System.out.println(Thread.currentThread().getName() + " ����----- " + this.one);

        this.flag = true;
        this.notifyAll();
    }

    synchronized void get() {
        while(!this.flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " ����------- " + this.one);

        this.flag = false;
        this.notifyAll();
    }

}

// ������
class Producer implements Runnable {

    private Resource one;

    Producer(Resource one) {
        this.one = one;
    }

    @Override
    public void run() {
        while(true) {
            one.set("��Ʒ");
        }
    }
}

// ������
class Consumer implements Runnable {

    private Resource one;

    Consumer(Resource one) {
        this.one = one;
    }

    @Override
    public void run() {
       while(true) {
           one.get();
       }
    }
}


