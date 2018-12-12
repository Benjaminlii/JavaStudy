package textMultithread;

/**
 * ����ʹ�ü̳�Thread������̵߳Ĵ���
 *
 * ͨ������һ��Thread�������������һ���߳�
 * �̵߳�������ڸ������run�����У��൱�����̵߳�main����
 * �̴߳���֮�󲢲������У������̵߳�run����Ҳ���������߳�
 * ��Ҫ���������start���������߳�
 * start������֪ͨJVM��������������̲߳����Զ�����߳���ִ��run����
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
        for(int i = 0; i < 1000; i++){
            System.out.println(this.getName() + "---" + i);
        }
    }
}

public class textThread {
    public static void main(String[] args) {
        // �����̣߳���ʱ�ڴ��в�û���Զ�����̣߳�ֻ���Ѿ��������
        // �ڵ���start����֮�󣬲Ż��������̣߳����̡߳�one��two��
        Thread1 one = new Thread1("one");
        Thread1 two = new Thread1("two");
        one.start();
        two.start();
    }
}
