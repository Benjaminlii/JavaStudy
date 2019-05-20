package play;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * whatever,write something.
 * <p>
 * author:Benjamin
 * date:2018.12.24
 */


public class DownLoadByURL {
    /**
     * TODO 下载文件到本地
     *
     * @author nadim  
     * @date Sep 11, 2015 11:45:31 AM
     * fileUrl 远程地址
     * fileLocal 本地路径
     * throws Exception 
     *      
     */
    public static void main(String[] args) throws Exception {
        testDownloadFile();
    }

    public static void testDownloadFile() {
        String fileUrl = "magnet:?xt=urn:btih:e1216c5da9de1361489d8e694caa78b32f1ffacb&dn=Game.of.Thrones.S08E06.1080p.WEB.H264-MEMENTO%5Brartv%5D&tr=http%3A%2F%2Ftracker.trackerfix.com%3A80%2Fannounce&tr=udp%3A%2F%2F9.rarbg.me%3A2760&tr=udp%3A%2F%2F9.rarbg.to%3A2780";
        String fileLocal = "E:\\GameOfThronesS08E06.mkv";
        URL url = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            url = new URL(fileUrl);
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
            urlCon.setConnectTimeout(6000);
            urlCon.setReadTimeout(6000);
            int code = urlCon.getResponseCode();
            if (code != HttpURLConnection.HTTP_OK) {
                throw new Exception("文件读取失败");
            }
            //读文件流
            in = new DataInputStream(urlCon.getInputStream());
            out = new DataOutputStream(new FileOutputStream(fileLocal));
            byte[] buffer = new byte[2048];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

