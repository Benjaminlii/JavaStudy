package play;

import java.util.Scanner;

/**
 * �����һ���ܹ��ϵ����Ⱑ
 * ���п��Ե�ʱ���ûŪ��
 * ʵ���ϻ����Լ�Ӣ��ѧ�Ĳ���
 * ��������û���壬�����1�º�2�£����Ҫ-1
 * Ҳ����˵������㷨���棬һ���Ǵ�һ���3�µ��ڶ����2��
 * �ڼ���֮ǰҪ������Ӧ��ת��
 * author:Benjamin
 * date:2018.12.21
 */

class Zellers {
    /**
     * h Ϊ���ڵ��±�(0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4:Wednesday, 5: Thursday, 6: Friday).
     * q Ϊ�����е�day
     * m Ϊ�����е�month��1�º�2�·ֱ��Ӧ��ǰһ�ꡱ��13�º�14�£�ǰһ�껮�ص�
     * j Ϊ������-1��year / 100��
     * k Ϊ��ǰ���ڱ����͵�������year % 100��
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
