package play;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * PTA上那个求星期的算法我还是写不出来
 * 也不是写不出来，我感觉我没问题，但就是答案错误
 * 我自己运行也不知道那个点除了问题
 * 可能对算法理解出了问题
 * 于时，就不要怪我了，我就不信我用data类和Calendar类还能出错？
 * 机智如我
 * 先用new Date("month-day-year");构造器构造Date对象，虽然过时了，不过用一下还是可以的
 * 然后Calendar.getInstance();得到一个Calendar对象（Calendar对象是对事件进行操作的对象）
 * 然后用Calendar.setTime(Date time);设置要操作的时间
 * Calendar.get(Calendar.DAY_OF_WEEK);得到星期几，这个是1-7的数字（1为周日Sunday）
 * author:Benjamin
 * date:2018.12.18
 */

public class GetDayOfWeek {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        in.close();

        Date oneDay = new Date(month + "/" + day + "/" + year);
        Calendar c = Calendar.getInstance();
        c.setTime(oneDay);
        int a = c.get(Calendar.DAY_OF_WEEK);
        String[] weekDay = {"Saturday", "Sunday", "Monday"
                , "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.println(weekDay[a]);
    }
}
