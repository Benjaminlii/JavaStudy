package textMultithread;

/**
 * ���ڲ���ʵ��Runnable�ӿ���ʵ�ֶ��߳�
 *
 * ������Ķ��󣬲���ʵ��runnable�ӿڣ���Runnable�ӿڵ�run����������Զ����߳�Ҫ���еĴ���
 * ����Thread���󣬲���Runnable�ӿڵ�����������������Ĳ�������Thread������Ҫ�ǵõ�run������
 * ��ʱ�߳̾��Ѿ�������
 * ����start�����������߳�
 * ����ͨ��Thread����ķ��������ƽ��̵�״̬
 *
 * ǰһ��ʹ��Thread������ʵ�ֶ��߳�ʵ�����ǽ�Thread���е�run��������
 * �����ʹ�ô���Runnable�ӿڵ����������ʵ�����ǽ�run�������뵽Thread������
 * Thread���run����Դ�룺
 *      public void run() {
 *          if (target != null) {
 *              target.run();
 *          }
 *      }
 * target���Ǵ����Runnable�������δ����target����ô��Ӧ�ø���run����
 *
 * ʵ��Runnable�ӿڵĺô���
 *      1�������̵߳�ʵ������߳�ִ�еĴ������
 *      2������Java���̳еľ�����
 * ���ַ�ʽʵ�ֶ��߳̽�Ϊ����
 *
 * author:Benjamin
 * date:2018.12.12
 */
class doInOtherThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}

public class textRunnable {
    public static void main(String[] args) {
        Thread t1 = new Thread(new doInOtherThread());
        Thread t2 = new Thread(new doInOtherThread());
        t1.start();
        t2.start();
    }
}
