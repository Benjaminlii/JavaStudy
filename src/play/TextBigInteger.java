package play;

import java.math.BigInteger;

/**
 * 超大数计算，使用BigInteger类进行帮助
 * BigInteger类的对象可以将字符对象转换成大数的数字对象
 * 并可以根据相应的计算规则进行四则运算等运算
 * author:Benjamin
 * date:2018.12.19
 */

public class TextBigInteger {
    public static void main(String[] args) {

        long num = (long)Math.sqrt(Long.MAX_VALUE)+1;
        BigInteger big = new BigInteger(String.valueOf(num));
        BigInteger numberOfOne = new BigInteger("1");
        for(int i = 0; i < 10; i++){
            System.out.println(big.pow(2));
            big = big.add(numberOfOne);
        }

    }
}
