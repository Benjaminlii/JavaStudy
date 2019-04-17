package JavaSE.textIOStream;

import java.io.*;

/**
 * ʹ��BufferedInputStream �� BufferedOutputStream ����MP3�ļ��ĸ���
 *
 * data:2019.3.28
 * author:Benjamin
 */

public class TextBufferedIOStream {
    public static void main(String[] args) {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\JavaSE.textIOStream\\Լ��.flac"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\JavaSE.textIOStream\\Լ��(copy).flac"))
        ) {
            int bt;
            long start = System.currentTimeMillis();
            while((bt = bis.read())!=-1){
                bos.write(bt);
            }
            long end = System.currentTimeMillis();
            System.out.println((end-start) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
