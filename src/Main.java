import java.util.*;

/**
 * whatever,write something.
 * <p>
 * author:Benjamin
 * date:2018.12.24
 */

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> one = new ArrayList<>();
        int num = in.nextInt() + in.nextInt();
        for(int i = 0; i < num; i ++){
            one.add(in.nextInt());
        }
        Collections.sort(one);
        for(int i : one){
            System.out.printf("%d ", i);
        }
    }
}