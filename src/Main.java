import java.math.BigInteger;
import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger m = new BigInteger(in.next());
        BigInteger one = new BigInteger("1");
        int n = in.nextInt();

        while(n>0){
            if(m.isProbablePrime(1)){
                n--;
                System.out.println(m);
            }
            m = m.add(one);
        }

        in.close();
    }
}