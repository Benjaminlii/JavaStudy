package textIOStream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 终于开IO流了，之前本来想在多线程之前看的，网课顺序不一样
 * 就先学了多线程
 *
 * IO流可以分为输入流、输出流，也可以分为字符流和字节流
 * 顶层父类：    InputStream（字节输入）
 *              OutputStream（字节输出）
 *              Reader（字符输入）
 *              Writer（字符输出）
 *
 * 先从字符流开始学习
 * FileWriter类（继承关系：Object->Writer->OutputStreamWriter->FileWriter）
 * 构造器： FileWriter(String FileName);    创建名为FileName的文件写入流，有则覆盖。
 * 方法     FileWriter.flush();             刷新缓冲区域，将缓冲区域中的字符写入文件中。
 *          FileWriter.close();             关闭流，在关闭之前会进行刷新操作。
 *
 * author:Benjamin
 * date:2018.12.22
 */

class TxtWriter{

    private FileWriter fw;

    TxtWriter(String fileName) throws IOException {
        this.fw = new FileWriter(fileName);
    }

    void write(String data) throws IOException {
        this.fw.write(data);
        this.fw.flush();
    }
}

public class TextFileWriter {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            TxtWriter one = new TxtWriter("src\\textIOStream\\one.txt");
            one.write(in.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
