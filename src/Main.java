import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GregorianCalendar oneTime = new GregorianCalendar();
        oneTime.setTimeInMillis(in.nextLong());
        System.out.println(oneTime.get(Calendar.YEAR) + "-" +
                oneTime.get(Calendar.MONTH) + "-" +
                oneTime.get(Calendar.DAY_OF_MONTH));

        in.close();
    }
}