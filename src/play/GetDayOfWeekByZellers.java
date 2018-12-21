package play;

import java.util.Scanner;

/**
 * 解决了一个很古老的问题啊
 * 期中考试的时候就没弄对
 * 实际上还是自己英文学的不好
 * 连条件都没看清，如果是1月和2月，年份要-1
 * 也就是说，这个算法里面，一年是从一年的3月到第二年的2月
 * 在计算之前要进行相应的转换
 * author:Benjamin
 * date:2018.12.21
 */

class Zellers {
    /**
     * h 为星期的下标(0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4:Wednesday, 5: Thursday, 6: Friday).
     * q 为日期中的day
     * m 为日期中的month，1月和2月分别对应“前一年”的13月和14月，前一年划重点
     * j 为世纪数-1（year / 100）
     * k 为当前年在本世纪的年数（year % 100）
     */
    private static String[] weekDay = {"Saturday", "Sunday", "Monday"
            , "Tuesday", "Wednesday", "Thursday", "Friday"};
    private int h;

    Zellers(int year, int month, int day) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int m = month;
        int j = year / 100;
        int k = year % 100;
        this.h = (day + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
    }

    String getDayOfWeek() {
        return weekDay[this.h];
    }
}

public class GetDayOfWeekByZellers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Zellers one = new Zellers(in.nextInt(),in.nextInt(),in.nextInt());
        in.close();
        System.out.println(one.getDayOfWeek());
    }
}
