package textIOStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 复制一个txt文件
 * author:Benjamin
 * date:2018.12.24
 */
public class TextCopyAText {
    public static void main(String[] args) {

        try (FileReader read = new FileReader("src\\textIOStream\\one.txt");
             FileWriter write = new FileWriter("src\\textIOStream\\copy.txt")
        ) {
            int data;
            while((data = read.read())!=-1){
                write.write(data);
            }
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
