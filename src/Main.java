import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {

    private static void exchange(char[] array, int one, int two){
        char tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[]one = in.next().toCharArray();
        in.close();

        for(int i = 0; i < one.length; i++){
            int flag = i;
            for(int j = i+1; j<one.length;j++){
                if((int) one[flag] > (int) one[j]){
                    flag = j;
                }
            }
            exchange(one,i,flag);
        }

        System.out.println(one);
    }
}
