import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {
    private static boolean isAInt(char[] one) {
        for (char i : one) {
            if (!((int) i >= 48 && (int) i <= 57)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInt(String[] one) {
        for (String i : one) {
            if (!isAInt(i.toCharArray())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] one = new String[2];
        while (true) {
            one[0] = in.next();
            one[1] = in.next();
            if (!isInt(one)) {
                System.out.println("Incorrect input and re-enter two integers:");
            } else {
                System.out.println("Sum is " + (Integer.valueOf(one[0]) + Integer.valueOf(one[1])));
                break;
            }
        }

        in.close();
    }
}