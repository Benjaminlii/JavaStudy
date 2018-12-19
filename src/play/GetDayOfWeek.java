package play;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * PTA���Ǹ������ڵ��㷨�һ���д������
 * Ҳ����д���������Ҹо���û���⣬�����Ǵ𰸴���
 * ���Լ�����Ҳ��֪���Ǹ����������
 * ���ܶ��㷨����������
 * ��ʱ���Ͳ�Ҫ�����ˣ��ҾͲ�������data���Calendar�໹�ܳ���
 * ��������
 * ����new Date("month-day-year");����������Date������Ȼ��ʱ�ˣ�������һ�»��ǿ��Ե�
 * Ȼ��Calendar.getInstance();�õ�һ��Calendar����Calendar�����Ƕ��¼����в����Ķ���
 * Ȼ����Calendar.setTime(Date time);����Ҫ������ʱ��
 * Calendar.get(Calendar.DAY_OF_WEEK);�õ����ڼ��������1-7�����֣�1Ϊ����Sunday��
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
