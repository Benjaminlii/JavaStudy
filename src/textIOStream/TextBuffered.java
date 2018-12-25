package textIOStream;

import java.io.*;

/**
 * ����JavaIO�е��ַ���ȡ��д�룩��������BufferedWriter��BufferedReader
 * ��two.txtͨ��ʹ�û������������ΪcopyByBuffer.txt
 * two.txt�ĵ�ַ src\textIOStream\two.txt
 *
 * ����ʹ�û�������Ŀ��������߶�ȡ��д���Ч��
 * ������ʹ�ö�ȡ����ȡ�ļ���ÿ�ε���Read�����������Ӳ���ϵ��ļ����з��ʣ�Ч�ʺܵ�
 * ʹ�û��������ڴ�����������ʱ�򣬻����߶�ȡ��Ӧ��������С�����ݣ�������ڴ���
 * ֮����û�������ȡʵ���������Ѿ���ȡ���������н���ȡ�Ķ���
 * ����д������������Ϊ�����ĸ��ӵĻ�����̫С���������Ҳ���Զ��ķ���Ӳ�̽��д洢
 * �������൱�����������Ĭ�ϵĻ�����
 *
 * ����Ժ����˸��õ���⣬����и��¡�
 *
 * BufferedReader one = new BufferedReader(Reader in);  ����һ���ַ���ȡ����Reader���󣩵Ļ�����
 *      int BufferedReader.read();      �����ַ���ȡ
 *      int BufferedReader.read(char[] ch��int i, int len);     ���ַ������ȡ�ַ���intΪ��ʼ���±꣬lenΪ��ȡ�ĳ���
 *                                                              ����i��len��ʡ�ԣ���Ϊ�������ַ�����ĳ��ȶ�ȡ�ַ�
 *                                                              ����ֵΪ��ȡ�����ַ�����Ϊ�ļ���β��������ֵ���ܲ�����len��
 *      String BufferedReader.readLine()    ��ȡһ�е��ַ��������ַ�������
 *      void BufferedReader.cloth();    �ر������������Ҳ����˵��֮ǰ������������Ҫ�ٶ���Ĺر��ˣ�
 *
 * BufferedWriter ont = new BufferedWriter(Writer out); ����һ���ַ�д������Writer���󣩵Ļ�����
 *      void BufferedWriter.write(int ch);  ������д��һ���ַ�
 *      void BufferedWriter.write(char[] ch, int i, int len);   ���ַ�����д���ַ�����iΪ�±�ĵط���ʼ��д��len���ַ�
 *                                                              ����i��len��ʡ�ԣ���Ϊд����������
 *      void BufferedWriter.newLine();  д��һ�����з�
 *      void BufferedWriter.flush();    ˢ�»�����������д��Ĳ���
 *      void BufferedWriter.cloth();    �ر������������Ҳ����˵��֮ǰ������������Ҫ�ٶ���Ĺر��ˣ�
 *
 * author:Benjamin
 * date:2018.12.25
 * Merry Christmas!
 */
public class TextBuffered {
    public static void main(String[] args) throws IOException {
        // ����Ͳ������쳣�Ĵ����ˣ�ֱ���׳�����Ҳûʲô�ô����
        FileReader fr = new FileReader("src\\textIOStream\\two.txt");
        BufferedReader bufR = new BufferedReader(fr);
        FileWriter fw = new FileWriter("src\\textIOStream\\copyByBuffer.txt");
        BufferedWriter bufW = new BufferedWriter(fw);

        for (int i = 0; i < 5; i++) {
            bufW.write(bufR.readLine());
            bufW.newLine();
            bufW.flush();
        }

        bufR.close();
        bufW.close();

    }
}
