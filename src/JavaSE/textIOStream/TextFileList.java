package JavaSE.textIOStream;

import java.io.File;

/**
 * ʹ��File��ķ������ļ��б���в���
 * <p>
 * File[] File.listRoot();File���еľ�̬����������ϵͳ��Ŀ¼�µ��̷��б�File��
 * String[] list();���ص�ǰĿ¼�£��������ļ����Ҹ�Ŀ¼������ڣ��������ļ�����ɵ��ַ������飻
 * String[] list(FilenameFilter ff);����һ��ʵ����FilenameFilter�ӿڵ���
 * ʹ�ø����е�accept(File dir, String name)�������ж��ļ�����ɸѡ
 * File[] listFiles();���ظ�Ŀ¼�µ��ļ���Fileʵ������
 * <p>
 * author:Benjamin
 * date:2019.3.29
 */


public class TextFileList {
    public static void main(String[] args) {
        method_2();
    }

    public static void method_0() {
        File[] one = File.listRoots();
        for (File f : one) {
            System.out.println(f.toString());
        }
    }

    public static void method_1() {
        File f = new File("c:\\");

        String[] name = f.list();
        for (String s : name) {
            System.out.println(s);
        }
    }

    public static void method_2() {
        File f = new File("src\\JavaSE.textIOStream");
        String[] name = f.list((dir, name1) -> name1.endsWith(".java"));
        for (String s : name) {
            System.out.println(s);
        }
    }

}

