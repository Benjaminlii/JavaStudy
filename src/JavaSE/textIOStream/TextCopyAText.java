package JavaSE.textIOStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ����һ��txt�ļ�
 * ����һ��һ���ַ���ȡ�������д洢��Ҳ����һ���Զ�ȡ����ַ��������ݶ�ȡ���ĸ������д洢
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
