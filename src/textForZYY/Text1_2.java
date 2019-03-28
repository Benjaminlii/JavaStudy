package textForZYY;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 读取一个数n
 * 打印0~n之间所有的奇数
 * <p>
 * author:zyy
 * date:2019.3.13
 */

public class Text1_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)
                System.out.println(i);
        }
        in.close();
    }
}
