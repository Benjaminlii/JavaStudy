package JavaSE.textIOStream;

import java.io.File;

/**
 * 使用File类的方法对文件列表进行操作
 * <p>
 * File[] File.listRoot();File类中的静态方法，返回系统根目录下的盘符列表（File）
 * String[] list();返回当前目录下（不能是文件，且该目录必须存在）的所有文件名组成的字符串数组；
 * String[] list(FilenameFilter ff);传入一个实现了FilenameFilter接口的类
 * 使用该类中的accept(File dir, String name)方法进行对文件名的筛选
 * File[] listFiles();返回该目录下的文件的File实例数组
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

