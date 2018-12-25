package textIOStream;

import java.io.*;

/**
 * 测试JavaIO中的字符读取（写入）缓冲区类BufferedWriter和BufferedReader
 * 将two.txt通过使用缓冲区类对象复制为copyByBuffer.txt
 * two.txt的地址 src\textIOStream\two.txt
 *
 * 这里使用缓冲区的目的在于提高读取和写入的效率
 * 单纯的使用读取流读取文件，每次调用Read方法，都会对硬盘上的文件进行访问，效率很低
 * 使用缓冲区，在创建缓冲区的时候，会于线读取相应缓冲区大小的内容，存放在内存中
 * 之后调用缓冲区读取实际上是在已经读取到的数据中进行取的动作
 * 至于写入流，暂且认为是流的附加的缓冲区太小，如果放满也会自动的访问硬盘进行存储
 * 缓冲区相当于扩大了这个默认的缓冲区
 *
 * 如果以后有了更好的理解，会进行更新。
 *
 * BufferedReader one = new BufferedReader(Reader in);  创建一个字符读取流（Reader对象）的缓冲区
 *      int BufferedReader.read();      单个字符读取
 *      int BufferedReader.read(char[] ch，int i, int len);     以字符数组读取字符，int为开始的下标，len为读取的长度
 *                                                              参数i和len可省略，意为按整个字符数组的长度读取字符
 *                                                              返回值为读取到的字符（若为文件结尾处，返回值可能不等于len）
 *      String BufferedReader.readLine()    读取一行的字符，并以字符串返回
 *      void BufferedReader.cloth();    关闭相关联的流（也就是说，之前创建的流不需要再额外的关闭了）
 *
 * BufferedWriter ont = new BufferedWriter(Writer out); 创建一个字符写入流（Writer对象）的缓冲区
 *      void BufferedWriter.write(int ch);  以整形写入一个字符
 *      void BufferedWriter.write(char[] ch, int i, int len);   以字符数组写入字符，从i为下标的地方开始，写入len个字符
 *                                                              参数i和len可省略，意为写入整个数组
 *      void BufferedWriter.newLine();  写入一个换行符
 *      void BufferedWriter.flush();    刷新缓冲区，进行写入的操作
 *      void BufferedWriter.cloth();    关闭相关联的流（也就是说，之前创建的流不需要再额外的关闭了）
 *
 * author:Benjamin
 * date:2018.12.25
 * Merry Christmas!
 */
public class TextBuffered {
    public static void main(String[] args) throws IOException {
        // 这里就不进行异常的处理了，直接抛出，这也没什么好处理的
        FileReader fr = new FileReader("src\\textIOStream\\two.txt");
        BufferedReader bufR = new BufferedReader(fr);
        FileWriter fw = new FileWriter("src\\textIOStream\\copyByBuffer.txt");
        BufferedWriter bufW = new BufferedWriter(fw);

        for (int i = 0; i < 5; i++) {
            bufW.write(bufR.readLine());
            bufW.newLine();
            bufW.flush();
        }

        bufR.close();
        bufW.close();

    }
}
