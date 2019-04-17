package JavaSE.textIOStream;

import java.io.*;

public class MyBufferedInputStream {
    private byte[] bt = new byte[1024];
    private int pos = 0, count = 0;
    private FileInputStream fis;

    private MyBufferedInputStream(FileInputStream fis) {
        this.fis = fis;
    }

    private int myRead() {
        if (count == 0) {
            try {
                count = this.fis.read(bt);
            } catch (IOException e) {
                e.printStackTrace();
            }
            pos = 0;
        }else if(count > 0) {
            byte rtn = bt[pos];
            count--;
            pos++;
            return rtn;
        }
        return -1;
    }

    private void myClose() {
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        MyBufferedInputStream mbis = new MyBufferedInputStream(new FileInputStream("src\\JavaSE.textIOStream\\约定.flac"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src\\JavaSE.textIOStream\\约定(bufCopy).flac"));

        int bt;
        long start = System.currentTimeMillis();
        while((bt = mbis.myRead()) != -1){
            bos.write(bt);
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start) + "ms");

        mbis.myClose();
        bos.close();

    }
}
