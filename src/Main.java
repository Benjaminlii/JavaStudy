import java.util.Scanner;

/**
 * '.' -(int)-> 46
 * '0'~'9' -(int)-> 48~57
 * 还加入了判断小数点个数的机制
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] one = in.next().toCharArray();
        in.close();

        int count = 0;
        for (char i : one) {
            if (i == '.') {
                count++;
            }
        }
        if (count > 1) {
            System.out.println("false");
            return;
        }

        for (char i : one) {
            if (!((int) i >= 48 && (int) i <= 57 || (int) i == 46)) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
