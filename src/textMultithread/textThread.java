package textMultithread;

/**
 * ����ʹ�ü̳�Thread������̵߳Ĵ���
 *
 * ͨ������һ��Thread�������������һ���̣߳����Ҹ���Thread���run����
 * �̵߳�������ڸ������run�����У��൱�����̵߳�main����
 * �̴߳���֮�󲢲������У������̵߳�run����Ҳ���������߳�
 * ��Ҫ���������start���������߳�
 * start������֪ͨJVM��������������̲߳����Զ�����߳���ִ��run����
 *
 * �ڶ��߳��У��쳣ֻ��Ӱ�����������̣߳������̵߳Ľ��в���Ӱ��
 * �����̵߳�״̬��
 *      �̵߳�״̬���·�Ϊ�����������С�˯�ߡ���ʱ����������
 *      Thread�������һ��ʵ���������̾ͱ�������
 *      ���ø������start����֮�󣬸ý��̱�Ϊ����״̬
 *      �������еĽ��̿���ͨ��sleep��time����������˯�ߣ�timeΪ���Ͳ���������Ϊ˯�ߵ�ʱ�䣬��λΪ����
 *      ��timeʱ����󣬽����Զ�ת��Ϊ����״̬
 *      Ҳ����ͨ��wait���ȴ���������notify�����ѣ����������к�˯������״̬֮��ת��
 *      �������еĽ�������CPU�����ִ�У�ͬһʱ�䣬CPUֻ��ִ��һ�����̣�������CPU�ڽ��п��ٵ��л������Ը��˵ĸо�����ͬʱִ�У�
 *      Ҫ���еĽ���������һ�����ڱ�ִ�У������Ľ������Ŷӣ�����Ŷӵ�״̬������ʱ����
 *      ��ʱ����״̬�Ľ�����CPU��ִ���ʸ񣬵���û��ִ��Ȩ�����ڵȴ�CPU��Դ�ķ���
 *      ˯��״̬�Ľ���û��CPU��ִ��ȨҲû��ִ���ʸ񣬻��Ѻ����µõ�ִ��ȨҲû��ִ���ʸ�
 *      �������̵�run�������н��������ߵ�����stop�������ѹ�ʱ��֮�󣬽��̾ͻ�����
 *
 * �������ҵ���CPU�ܵĻ�ͦ��
 *
 * author:Benjamin
 * date:2018.12.12
 */

class Thread1 extends Thread{
    Thread1(String name) {
        super(name);
    }

    // run�����������Զ����߳���Ҫ���еĴ���
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            // ͨ��Thread.getName()�������Եõ��̵߳����ƣ�Ĭ��Ϊ Thread-0,1,2,3....
            // currentThread()�������Է��ص�ǰ���ڽ��е��̵߳Ķ��󣬶�Thread.getName()�õ��Ĳ�һ�����������еĶ��������
            // �磺����run���������̵߳���ԭ��Ӧ�����Զ����߳������еĴ��룬����Thread.getName()�õ���ʱ�Զ�����߳���
            // ���������е������߳�
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}

public class textThread {
    public static void main(String[] args) throws InterruptedException {
        // �����̣߳���ʱ�ڴ��в�û���Զ�����̣߳�ֻ���Ѿ��������
        // �ڵ���start����֮�󣬲Ż��������̣߳����̡߳�one��two��
        Thread1 one = new Thread1("one");
        Thread1 two = new Thread1("two");
        one.start();
        two.start();
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
            // ˯��5000���룬Ҳ����5��
            if(i == 50) Thread.sleep(5000);
        }
    }
}