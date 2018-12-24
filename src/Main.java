import java.util.Scanner;

/**
 * author:Benjamin
 */
public class Main {
    public static Object max(Comparable[] a) {
        int flag = 0;
        for(int i = 0;i < a.length; i++){
            if(a[flag].compareTo(a[i]) < 0){
                flag = i;
            }
        }
        return a[flag];
    }

    public static void main(String[] args) {
        String[] sArray = new String[5];
        Integer[] intArray = new Integer[5];
        Scanner input = new Scanner(System.in);
        for(int i=0;i<sArray.length;i++)  {
            sArray[i] = input.next();
        }

        for(int i=0;i<intArray.length;i++)  {
            intArray[i] = new Integer(input.nextInt());
        }

        System.out.println("Max string is " +(String)max(sArray));
        System.out.println("Max integer is " + (Integer)max(intArray));
    }
}
