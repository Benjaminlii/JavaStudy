import java.math.BigInteger;
import java.util.Scanner;

/**
 * author:Benjamin
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger one = new BigInteger(in.next());
        BigInteger two = new BigInteger(in.next());
        System.out.println(one.divide(two));
        in.close();
    }
}
