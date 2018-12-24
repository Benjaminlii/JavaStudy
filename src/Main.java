import java.util.HashMap;
import java.util.Scanner;

/**
 * author:Benjamin
 * date:2018.12.24
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<String, String> list = new HashMap<>();

        String name;
        String number;

        while (true) {
            name = in.next();
            if (name.equals("noname")) {
                break;
            }
            number = in.next();
            list.put(name, number);
        }

        name = in.next();
        number = list.get(name);
        if (number == null) {
            number = "Not found.";
        }
        System.out.println(number);

        in.close();
    }
}
