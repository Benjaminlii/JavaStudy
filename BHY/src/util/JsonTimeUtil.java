package util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonTimeUtil {

    public static String getdate(Date date) {
        long time = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = simpleDateFormat.format(new Date(time));
        return result ;
    }
}
