package JavaSE.textIOStream;

import java.io.*;

/**
 * 使用BufferedReader和BufferedWriter进行文件的复制
 * <p>
 * date:2019.3.28
 * author:Benjamin
 */

public class TextCopyByBuffered {
    public static void main(String[] args) {
        try (FileReader r = new FileReader("src\\JavaSE.textIOStream\\one.txt");
             FileWriter w = new FileWriter("src\\JavaSE.textIOStream\\copyByBuffer.txt");
             BufferedReader br = new BufferedReader(r);
             BufferedWriter bw = new BufferedWriter(w);
        ) {
            String s;
            while((s = br.readLine()) != null){
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
