package textIOStream;

import java.io.File;
import java.io.IOException;

/**
 * File类的基本使用
 * 创建：
 * boolean createNewFile();若文件不存在，创建一个新的File文件并返回true，若已存在，则不创建返回false。
 * 和流不一样，使用流创建文件无论是否存在，都会创建一个新的文件或覆盖掉旧的文件。
 * boolean mkdir();创建文件夹
 * boolean mkdirs();创建多级文件夹
 * 删除：
 * boolean delete();删除文件，成功返回true，正在使用的文件无法删除，返回false。
 * boolean deleteOnExit();在程序退出时删除文件。
 * 判断：
 * boolean exists();判断文件是否存在。
 * // 判断是文件还是目录时，必须先进行文件是否存在的判断，不存在的文件都会返回false。
 * boolean isDirectory();判断是否是目录。
 * boolean isFile();判断是否是文件。
 * boolean isHidden();判断是否是隐藏文件。
 * boolean isAbsolute();判断是否为绝对路径。
 * <p>
 * 获取信息：
 * String getName();获取名称
 * String getPath();获取路径
 * String getParents();获取返回父目录的路径名字符串
 * long lastModified();返回此文件最后一次被修改的时间
 * long length():返回该文件的长度
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
        // 如果文件存在，删除文件
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
