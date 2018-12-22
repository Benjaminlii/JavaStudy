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
 *          FileWriter(String FileName, boolean append);    append��ʾ�Ƿ�Ϊ��д
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

    TxtWriter(String fileName, boolean isAppend) throws IOException {
        this.fw = new FileWriter(fileName, isAppend);
    }

    void write(String data) throws IOException {
        this.fw.write(data);
        this.fw.flush();
    }
}

public class TextFileWriter {

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)){
            // JDK1.7֮��try�������ԣ�������try�������Ӿֲ��������˳�try֮����Զ�close����Ҫʵ��Closeable�ӿ�
            // ��JDK1.7֮ǰ��IO�����ֵ��쳣����ǳ��鷳
            // Ҫ��try�ⲿ����������try�ڲ���ʼ��
            // ���Ҷ����closeҪ����finally�У�������close֮ǰ�ж��Ƿ�Ϊ��ָ�루����ʱ���쳣���³�ʼ��δ�ɹ���
            TxtWriter one = new TxtWriter("src\\textIOStream\\one.txt", true);
            one.write(in.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
