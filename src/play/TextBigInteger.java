package play;

import java.math.BigInteger;

/**
 * ���������㣬ʹ��BigInteger����а���
 * BigInteger��Ķ�����Խ��ַ�����ת���ɴ��������ֶ���
 * �����Ը�����Ӧ�ļ����������������������
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
