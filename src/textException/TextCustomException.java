package textException;

/**
 * 测试自定义异常，目前这样写好像是没什么用
 *
 * author:Benjamin
 */

import java.util.Scanner;

public class TextCustomException {
    public static void main(String[] args) {
        try {
            text0();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void text0() throws MyException {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.equals("error")) {
            System.out.println("Find a MyException!");
            throw new MyException("This String shouldn't equals to 'error'");
        }else {
            System.out.println("Every thing is OK!");
        }
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
