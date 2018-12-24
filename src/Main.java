import java.util.HashMap;
import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, Integer> list = new HashMap<>();

        String name;
        Integer number;

        while (true) {
            name = in.next();
            if (name.equals("noname")) {
                break;
            }
            number = in.nextInt();
            list.put(name, number);
        }

        name = in.next();
        number = list.get(name);
        if (number == null) {
            System.out.println("Not found.");
        }else{
            System.out.printf("%.2f", number*0.21);
        }

        in.close();
    }
}
