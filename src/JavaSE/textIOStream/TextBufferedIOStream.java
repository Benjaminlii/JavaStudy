package JavaSE.textIOStream;

import java.io.*;

/**
 * 使用BufferedInputStream 和 BufferedOutputStream 进行MP3文件的复制
 *
 * data:2019.3.28
 * author:Benjamin
 */

public class TextBufferedIOStream {
    public static void main(String[] args) {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\JavaSE.textIOStream\\约定.flac"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\JavaSE.textIOStream\\约定(copy).flac"))
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
