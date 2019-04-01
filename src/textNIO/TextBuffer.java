package textNIO;

import java.nio.ByteBuffer;

/**
 * ------------------------------------------------------------------------------------------
 * NIO(new IO)技术，jdk1.4之后出现
 * 与传统IO相比NIO是一种同步非阻塞的IO模型（IO是阻塞的）
 * IO面向流，而NIO面向缓冲区
 * ------------------------------------------------------------------------------------------
 * NIO的三大核心：Channel（通道）、Buffer（缓冲区）和Selector（选择区）
 * ------------------------------------------------------------------------------------------
 * Buffer（缓冲区）在JAVA NIO中负责数据的存取，本质是数组，用于存储不同类型的数据
 * 除boolean外，所有基本数据类型都有相应类型的缓冲区。
 * IntBuffer,ByteBuffer,CharBuffer,ShortBuffer,LongBuffer,FloatBuffer,DoubleBuffer
 * 通过缓冲区的allocate()方法来获取缓冲区
 * ------------------------------------------------------------------------------------------
 * 缓冲区的两个核心方法：
 * ····|-put() 向缓冲区中存入数据
 * ····|-get() 获取缓冲区中的数据
 * ------------------------------------------------------------------------------------------
 * 缓冲区的四个核心属性：
 * ····|-capacity：容量，表示缓冲区中的最大存储容量，一经声明，不可改变
 * ····|-limit：界限，表示缓冲区中可操作数据的大小（相当于有效空间）
 * ····|-position：位置，表示缓冲区中正在操作数据的位置
 * ····|-mark：标记，记录当前position的位置，可通过reset()回复到mark的位置
 * 0 <= mark <= position <= limit <= capacity
 * ------------------------------------------------------------------------------------------
 * 方法(以ByteBuffer为例)：
 * ····|- allocate(int)：类静态方法，返回一个指定大小的缓冲区
 * ····|- put(···)：向缓冲区中放置数据
 * ····|- get(···)：从缓冲区中读取数据
 * ····|- flip()：改变为读取模式（limit -> position, position -> 0）
 * ····|- rewind ：重置读取模式（position -> 0）
 * ····|- clear()：清空缓冲区（重置capacity = size, limit = capacity, position = 0）
 * ····|- mark()：标记当前position的位置
 * ····|- reset()：将position设置为mark曾标记的位置
 * ····|- hasRemaining()：判断缓冲区中是否还有可以操作的数据
 * ····|- remaining()：获得缓冲区中可操作数据的数量
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

        //存储数据
        System.out.println("-------------------------put--------------------------");
        buf.put(s.getBytes());
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //切换读取数据模式
        System.out.println("-------------------------flip--------------------------");
        buf.flip();
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //使用get()获取缓冲区中的数据
        System.out.println("-------------------------get--------------------------");
        byte[] buf_ = new byte[buf.limit()];
        buf.get(buf_);
        System.out.println(new String(buf_, 0, buf_.length));
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //rewind()重置position，可重复读取数据
        System.out.println("-------------------------position--------------------------");
        buf.rewind();
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");

        //clear()清空缓冲区,但缓冲区中的数据还在，只是重置了position、capacity、limit的值
        System.out.println("-------------------------clear--------------------------");
        buf.clear();
        System.out.println("buf.position() = " + buf.position());
        System.out.println("buf.limit() = " + buf.limit());
        System.out.println("buf.capacity() = " + buf.capacity() + "\n");
    }
}
