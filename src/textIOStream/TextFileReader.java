package textIOStream;

import java.io.FileReader;
import java.io.IOException;

/**
 * 测试文件读取的类
 * FileReader类（继承关系：Object->Reader->InputStreamReader->FileReader）
 * 构造器： FileReader(String fileName);    以fileName为名称关联一个文件
 *          FileReader(File file);          关联一个File对象
 * 方法：  int FileReader.read();      在文件中读取一个字符，并以整形返回
 *
 * author:Benjamin
 * date:2018.12.22
 */

public class TextFileReader {

    // 由于要演示异常的处理，所以不封装成类
    public static void main(String[] args) {
        try(FileReader one = new FileReader("src\\textIOStream\\one.txt")) {
            int ch;
            while((ch = one.read()) != -1){
                System.out.print((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
