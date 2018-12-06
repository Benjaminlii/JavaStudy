package textGenerics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ���Ե����� Iterator�������ϸ������Ͻ��������ڷ����࣬��������ʹ�ã����Է�������
 * Iterator��һ���ӿڣ�ʵ��������ӿڵ��඼����ʹ��util���е�Iterator������
 * �������൱����C������forѭ�����������һ����װ
 * �ô�����ʹ�õ��������Բ���Ҫ֪�����ͣ���ǳ��ʺ��ڶԷ�����������ʱʹ��
 * forѭ��һ�����ڼ򵥼��ϵı���
 * foreachѭ����Ҫ֪��������Ԫ������
 * ����������Ҫ֪����������ͣ�����Ҫ֪����С�����ҿ�����ʱͨ��remove�޸�������������
 * boolean Iterator.hasNext()   �ж��Ƿ��ܼ�������
 * object Iterator.next()   ������һ��Ԫ�أ���ָ������ƶ�һ��Ԫ�أ����ҽ���������Ԫ�ط���
 * void Iterator.remove()   ɾ�������������һ��Ԫ��
 *                          �����ٱ���ʱʹ��Iterator��remove������Collection�ӿڵ�remove
 *                          ԭ���ǣ�Iterator��remove�Ƚϰ�ȫ����ɾ��Ԫ��֮���ͬʱ���¼��϶�����Iterator�����Ԫ�ع�ϵ
 *                                  �����ʹ��Collection��remove��Iterator���󲻻ᱻ�ı䣬���������Ϳ��ܻ����
 * author:Benjamin
 * date:2018.12.6
 */
public class textIterator {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            one.add("" + i);
        }
        System.out.println("one = " + one);
        System.out.print("one(by Iterator) = ");

//        forѭ��ռ���ڴ���٣��ֲ�������
//        for (Iterator<String> forOne = one.iterator(); forOne.hasNext(); ) {
//            String oneData = forOne.next();
//            System.out.print(oneData + ",");
//        }
        Iterator<String> forOne = one.iterator();
        while(forOne.hasNext()){
            String s = forOne.next();
            System.out.print(s + ",");
        }

        //ʹ��Iterator��removeɾ�������е�Ԫ��
        forOne = one.iterator();
        while(forOne.hasNext()){
//            ���������"5"��ɾ�����±�������Ԫ��
            if(forOne.next().equals("5")){
                System.out.println("\nremove \"5\"");
                forOne.remove();
            }
        }
        System.out.println(one);

    }
}
