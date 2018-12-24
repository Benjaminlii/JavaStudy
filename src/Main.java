import java.math.BigInteger;
import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger num = new BigInteger(Long.MAX_VALUE + "");
        BigInteger one = new BigInteger("1");
        num = num.add(one);// 题目中是大于Long.MAX_VALUE的数
        BigInteger n = new BigInteger(in.next());
        int count = 0;

        while (count < 3) {
            if (num.mod(n).toString().equals("0")) {
                System.out.println(num);
                count++;
            }
            num = num.add(one);
        }

        in.close();
    }
}