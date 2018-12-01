package textException;

/**
 * 测试throws抛出方法中的错误
 * <p>
 * 在方法中可能会出现的异常，我们可以采取两种解决方案
 * 一种是在方法声明之后使用throws将该错误抛出，这样就必须在调用时使用try-catch来进行处理
 * 另一种是直接在方法的内部使用try-catch处理
 * 一般都是在调用的高层处处理异常
 *
 * author:Benjamin
 */

public class textThrows {
    private static void doIt() throws ArithmeticException {
//        随便写一个方法，这里以除法为例
//        实际上，这样运行时才会发现的错误，应该由if语句来排除
        int a = 1;
        int b = 0;
        if(b == 0){
//            抛出的异常必须是一个对象，而不是一个类，需要实例化
            throw new ArithmeticException("'b'should't equals to Zero.");
        }
        double answer = a / b;
        System.out.println(answer);
    }

    public static void main(String[] args) {
//      这里调用doIt（）方法，就必须进行异常的处理
        try {
            doIt();
        } catch (ArithmeticException e) {
//            这里一般选择输出异常的信息，相当于报错
            System.out.println("there has a Exception.");
            e.printStackTrace();
        }

    }
}
