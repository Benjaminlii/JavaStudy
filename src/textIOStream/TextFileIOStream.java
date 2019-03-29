package textIOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用FileInputStream和FileOutputStream完成图片的复制
 * <p>
 * data:2019.3.28
 * author:Benjamin
 */

public class TextFileIOStream {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src\\Image\\lion.jpg");
             FileOutputStream fos = new FileOutputStream("src\\Image\\copyLion.jpg")
        ) {
            byte[] buffer = new byte[1024];
            int count;
            while ((count = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
