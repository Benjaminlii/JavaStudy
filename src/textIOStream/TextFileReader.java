package textIOStream;

import java.io.FileReader;
import java.io.IOException;

/**
 * �����ļ���ȡ����
 * FileReader�ࣨ�̳й�ϵ��Object->Reader->InputStreamReader->FileReader��
 * �������� FileReader(String fileName);    ��fileNameΪ���ƹ���һ���ļ�
 *          FileReader(File file);          ����һ��File����
 * ������  int FileReader.read();      ���ļ��ж�ȡһ���ַ����������η���
 *
 * author:Benjamin
 * date:2018.12.22
 */

public class TextFileReader {

    // ����Ҫ��ʾ�쳣�Ĵ������Բ���װ����
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
