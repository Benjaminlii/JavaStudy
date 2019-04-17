package JavaSE.textMultithread;

/**
 * ����java�еĵ���ģʽ���Լ���֮��ص��̰߳�ȫ����Ľ����ʽ
 * ����ģʽ����һ����ֻ�����һ�����󣬲���ÿ��Ҫʹ����Ҫͨ�����е�get�����õ��ö���
 * �������ģʽ������һЩ����������磺��Ʊ������չʾҳ�棬��Ȼ��Ʊ�Ļ��������ж��������ʵ����Ʊ�Ĺ���
 * ����ҪչʾƱ����������ֻ��ʹ��һ��������Ϊ���еĻ�����Ӧ����ʾͬһ��չʾҳ�棬�������������Դ���˷�
 *
 * �ӳټ��ص������ģʽ���̰߳�ȫ����ʱ�ص�
 *
 * author:Benjamin
 * date:2018.12.13
 */
public class TextSingleton {
}

/**
 * ����ʽ���ӳټ��ص������ģʽ����
 *      ����Ҫ���ض���ʱ�Ż��жϽ��ж���Ĵ���
 *      ���ַ�ʽ����������ȽϿ飬���ǻ�ö����Ч�ʱȽϵ�
 */
class Single0{
    private static Single0 one = null;
    private Single0(){}
    public static Single0 getInstance(){
        if (Single0.one == null)
            one = new Single0();
        return one;
    }
}

/**
 * ����ʽ���̰߳�ȫ����
 * ���ڶ��߳����е���ģʽʱ���϶����й������ݣ��Ϳ϶������̰߳�ȫ����
 * ͨ��ͬ����������̰߳�ȫ���Ⲣ���������߳�֮ǰ����һ���жϣ����ⲻ��Ҫ���߳������������Ч��
 *
 * ���ֵ���ģʽʹ�õıȽ϶࣬���ԱȽϺõĽ���̰߳�ȫ����
 * �úڰ壡����
 */
class Single0_{
    private static Single0_ one = null;
    private Single0_(){}
    public static Single0_ getInstance(){
        // ���Ч�����⣬����Ѿ�����one��������Ҫ���������߳�
        if(Single0_.one == null) {
            // ����̰߳�ȫ����
            // �������ģʽ��getInstance�����Ǿ�̬�ģ�û��this����
            // ����ʹ�� ����.class ���ҵ����������̵߳�����
            synchronized (Single0_.class) {
                // ��one����֮�����߳������б�֤�̵߳İ�ȫ����
                if (Single0_.one == null)
                    one = new Single0_();
            }
        }
        return one;
    }
}

/**
 * ����ʽ���������ģʽ����
 *      �������ʱ�ͻᴴ����������
 *      ���ַ�ʽ����������Ƚ��������ǻ�ö����Ч�ʸ�
 */
class Single1{
    private static Single1 one = new Single1();
    private Single1(){}
    public static Single1 getInstance(){
        return one;
    }
}
