package JavaSE.textIOStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 复制一个txt文件
 * 可以一个一个字符读取，并进行存储，也可以一次性读取多个字符，并根据读取到的个数进行存储
 * author:Benjamin
 * date:2018.12.24
 */
public class TextCopyAText {
    public static void main(String[] args) {

        try (FileReader read = new FileReader("src\\JavaSE.textIOStream\\one.txt");
             FileWriter write = new FileWriter("src\\JavaSE.textIOStream\\copy.txt")
        ) {
            int len;
            char[] buf = new char[1024];
            while ((len = read.read(buf)) != -1) {
                write.write(buf, 0, len);
            }
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
