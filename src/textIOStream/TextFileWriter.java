package textIOStream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * ���ڿ�IO���ˣ�֮ǰ�������ڶ��߳�֮ǰ���ģ�����˳��һ��
 * ����ѧ�˶��߳�
 *
 * IO�����Է�Ϊ���������������Ҳ���Է�Ϊ�ַ������ֽ���
 * ���㸸�ࣺ    InputStream���ֽ����룩
 *              OutputStream���ֽ������
 *              Reader���ַ����룩
 *              Writer���ַ������
 *
 * �ȴ��ַ�����ʼѧϰ
 * FileWriter�ࣨ�̳й�ϵ��Object->Writer->OutputStreamWriter->FileWriter��
 * �������� FileWriter(String FileName);    ������ΪFileName���ļ�д���������򸲸ǡ�
 * ����     FileWriter.flush();             ˢ�»������򣬽����������е��ַ�д���ļ��С�
 *          FileWriter.close();             �ر������ڹر�֮ǰ�����ˢ�²�����
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
