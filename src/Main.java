import java.math.BigInteger;
import java.util.LinkedList;

/**
 * ≤›∏Â÷Ω
 * <p>
 * author:Benjamin
 */

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);

        LinkedList<Long> one = new LinkedList<>();
        long num = (long)Math.sqrt(Long.MAX_VALUE)+1;
        BigInteger big = new BigInteger(String.valueOf(num));
        BigInteger numberOfOne = new BigInteger("1");
        for(int i = 0; i < 10; i++){
            System.out.println(big.pow(2));
            big = big.add(numberOfOne);
        }

//        in.close();
    }
}
