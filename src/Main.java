import java.util.*;

/**
 * whatever,write something.
 * <p>
 * author:Benjamin
 * date:2018.12.24
 */

public class Main {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hellp";
        s3 = s3.replace('p', 'o');
        System.out.println(s1==s2);
        System.out.println(s1==s3);
    }
}