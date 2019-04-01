package textNIO;

import java.nio.ByteBuffer;

/**
 * ------------------------------------------------------------------------------------------
 * NIO(new IO)������jdk1.4֮�����
 * �봫ͳIO���NIO��һ��ͬ����������IOģ�ͣ�IO�������ģ�
 * IO����������NIO���򻺳���
 * ------------------------------------------------------------------------------------------
 * NIO��������ģ�Channel��ͨ������Buffer������������Selector��ѡ������
 * ------------------------------------------------------------------------------------------
 * Buffer������������JAVA NIO�и������ݵĴ�ȡ�����������飬���ڴ洢��ͬ���͵�����
 * ��boolean�⣬���л����������Ͷ�����Ӧ���͵Ļ�������
 * IntBuffer,ByteBuffer,CharBuffer,ShortBuffer,LongBuffer,FloatBuffer,DoubleBuffer
 * ͨ����������allocate()��������ȡ������
 * ------------------------------------------------------------------------------------------
 * ���������������ķ�����
 * ��������|-put() �򻺳����д�������
 * ��������|-get() ��ȡ�������е�����
 * ------------------------------------------------------------------------------------------
 * ���������ĸ��������ԣ�
 * ��������|-capacity����������ʾ�������е����洢������һ�����������ɸı�
 * ��������|-limit�����ޣ���ʾ�������пɲ������ݵĴ�С���൱����Ч�ռ䣩
 * ��������|-position��λ�ã���ʾ�����������ڲ������ݵ�λ��
 * ��������|-mark����ǣ���¼��ǰposition��λ�ã���ͨ��reset()�ظ���mark��λ��
 * 0 <= mark <= position <= limit <= capacity
 * ------------------------------------------------------------------------------------------
 * ����(��ByteBufferΪ��)��
 * ��������|- allocate(int)���ྲ̬����������һ��ָ����С�Ļ�����
 * ��������|- put(������)���򻺳����з�������
 * ��������|- get(������)���ӻ������ж�ȡ����
 * ��������|- flip()���ı�Ϊ��ȡģʽ��limit -> position, position -> 0��
 * ��������|- rewind �����ö�ȡģʽ��position -> 0��
 * ��������|- clear()����ջ�����������capacity = size, limit = capacity, position = 0��
 * ��������|- mark()����ǵ�ǰposition��λ��
 * ��������|- reset()����position����Ϊmark����ǵ�λ��
 * ��������|- hasRemaining()���жϻ��������Ƿ��п��Բ���������
 * ��������|- remaining()����û������пɲ������ݵ�����
 * ------------------------------------------------------------------------------------------
 * author:Benjamin
 * date:2019.4.1
 * ------------------------------------------------------------------------------------------
 */

public class TextBuffer {
    public static void main(String[] args) {
        String s = "abcdefg";

        System.out.println("-------------------------allocate--------------------------");
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //�洢����
        System.out.println("-------------------------put--------------------------");
        buf.put(s.getBytes());
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //�л���ȡ����ģʽ
        System.out.println("-------------------------flip--------------------------");
        buf.flip();
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //ʹ��get()��ȡ�������е�����
        System.out.println("-------------------------get--------------------------");
        byte[] buf_ = new byte[buf.limit()];
        buf.get(buf_);
        System.out.println(new String(buf_, 0, buf_.length));
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //rewind()����position�����ظ���ȡ����
        System.out.println("-------------------------position--------------------------");
        buf.rewind();
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //clear()��ջ�����,���������е����ݻ��ڣ�ֻ��������position��capacity��limit��ֵ
        System.out.println("-------------------------clear--------------------------");
        buf.clear();
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");
    }
}
