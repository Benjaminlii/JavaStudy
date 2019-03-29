package textIOStream;

import java.io.File;
import java.io.IOException;

/**
 * File��Ļ���ʹ��
 * ������
 * boolean createNewFile();���ļ������ڣ�����һ���µ�File�ļ�������true�����Ѵ��ڣ��򲻴�������false��
 * ������һ����ʹ���������ļ������Ƿ���ڣ����ᴴ��һ���µ��ļ��򸲸ǵ��ɵ��ļ���
 * boolean mkdir();�����ļ���
 * boolean mkdirs();�����༶�ļ���
 * ɾ����
 * boolean delete();ɾ���ļ����ɹ�����true������ʹ�õ��ļ��޷�ɾ��������false��
 * boolean deleteOnExit();�ڳ����˳�ʱɾ���ļ���
 * �жϣ�
 * boolean exists();�ж��ļ��Ƿ���ڡ�
 * // �ж����ļ�����Ŀ¼ʱ�������Ƚ����ļ��Ƿ���ڵ��жϣ������ڵ��ļ����᷵��false��
 * boolean isDirectory();�ж��Ƿ���Ŀ¼��
 * boolean isFile();�ж��Ƿ����ļ���
 * boolean isHidden();�ж��Ƿ��������ļ���
 * boolean isAbsolute();�ж��Ƿ�Ϊ����·����
 * <p>
 * ��ȡ��Ϣ��
 * String getName();��ȡ����
 * String getPath();��ȡ·��
 * String getParents();��ȡ���ظ�Ŀ¼��·�����ַ���
 * long lastModified();���ش��ļ����һ�α��޸ĵ�ʱ��
 * long length():���ظ��ļ��ĳ���
 * <p>
 * <p>
 * <p>
 * date:2019.3.29
 * author:Benjamin
 */

public class TextFile {
    public static void main(String[] args) {
        method_4();
    }

    public static void method_1() throws IOException {
        File f = new File("File.txt");
        // ����ļ����ڣ�ɾ���ļ�
        if (f.exists())
            System.out.println("if delete ? " + f.delete());
        System.out.println("if create ? " + f.createNewFile());
    }

    public static void method_2() {
        File f = new File("src\\textIOStream\\makeByMkDirs\\a\\b\\c\\d\\e\\f");
        System.out.println("if mkDir? " + f.mkdirs());
    }

    public static void method_3() {
        File f = new File("src\\textIOStream\\makeByMkDirs\\a\\b\\c\\d\\e\\f");
        System.out.println("is a File? " + f.isFile());
        System.out.println("is a Directory? " + f.isDirectory());
        System.out.println("is it Absolute? " + f.isAbsolute());
    }

    public static void method_4(){
        File f = new File("src\\textIOStream\\makeByMkDirs\\a\\b\\c\\d\\e\\f");
        System.out.println("Path : " + f.getPath());
        System.out.println("Name : " + f.getName());
        System.out.println("Absolute path: " + f.getAbsolutePath());
    }
}
