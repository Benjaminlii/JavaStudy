package textIOStream;

import java.io.FileReader;
import java.io.IOException;

/**
 * 测试文件读取的类
 * FileReader类（继承关系：Object->Reader->InputStreamReader->FileReader）
 * 构造器： FileReader(String fileName);    以fileName为名称关联一个文件
 *          FileReader(File file);          关联一个File对象
 * 方法：  int FileReader.read();      在文件中读取一个字符，并以整形返回，若文件结束，返回-1
 *         int FileReader.read(char[] ch);  在文件中按批次读取字符，一个批次的大小为传入数组的大小，将读取结果存放在数组中
 *                                              返回值为读取到的字符数，若文件结束，返回0。
 *                                              存储形式为覆盖，也就是说读取不到字符或读取到文件末尾时，只会更新前半部分的数组
 *
 * author:Benjamin
 * date:2018.12.22
 */

public class TextFileReader {

    // 由于要演示异常的处理，所以不封装成类
    public static void main(String[] args) {
        try(FileReader one = new FileReader("src\\textIOStream\\one.txt")) {
            char[] ch = new char[10];
            while((one.read(ch)) != -1){
                System.out.print(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
