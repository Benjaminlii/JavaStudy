package textIOStream;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * ´øÐÐºÅ¶ÁÈ¡
 * <p>
 * date:2019.3.28
 * author:Benjamin
 */

public class TextLineNumberReader {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("src\\textIOStream\\TextLineNumberReader.java");
             LineNumberReader lnr = new LineNumberReader(fr)
        ) {
            String s;
            while ((s = lnr.readLine()) != null) {
                System.out.println(lnr.getLineNumber() + " :" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
