package textIOStream;

import java.io.FileReader;
import java.io.IOException;

/**
 * �����ļ���ȡ����
 * FileReader�ࣨ�̳й�ϵ��Object->Reader->InputStreamReader->FileReader��
 * �������� FileReader(String fileName);    ��fileNameΪ���ƹ���һ���ļ�
 *          FileReader(File file);          ����һ��File����
 * ������  int FileReader.read();      ���ļ��ж�ȡһ���ַ����������η��أ����ļ�����������-1
 *         int FileReader.read(char[] ch);  ���ļ��а����ζ�ȡ�ַ���һ�����εĴ�СΪ��������Ĵ�С������ȡ��������������
 *                                              ����ֵΪ��ȡ�����ַ��������ļ�����������0��
 *                                              �洢��ʽΪ���ǣ�Ҳ����˵��ȡ�����ַ����ȡ���ļ�ĩβʱ��ֻ�����ǰ�벿�ֵ�����
 *
 * author:Benjamin
 * date:2018.12.22
 */

public class TextFileReader {

    // ����Ҫ��ʾ�쳣�Ĵ������Բ���װ����
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
