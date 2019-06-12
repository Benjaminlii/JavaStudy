package util;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据库中的java.sql.Date不能和java.util.Date相互转换，所以使用new Timestamp(simpleDateFormat.parse(string).getTime())
 */
public class DateStringUtil {

    public static String dateToString(Timestamp date) {
        long time = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date(time));
    }


    public static Timestamp stringToDate(String string){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp date = null;
        try {
            date = new Timestamp(simpleDateFormat.parse(string).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
