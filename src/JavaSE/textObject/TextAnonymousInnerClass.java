package JavaSE.textObject;

/**
 * 用于测试匿名内部类
 *
 * 匿名内部类，在方法调用时作为参数传入到方法内，在方法内部调用内部类的某些方法
 * 因为总是以调用某类的某中方法，所以通常以接口为模板
 * 适用于，需要调用方法需要调用参数的某属性（也就是将类作为参数传入，但在调用时必须实现类）
 *
 * date:2018.12.1
 * author:Benjamin
 */

public class TextAnonymousInnerClass {
    private static void doIt(someOne one){
        one.toDoSomething();
    }

    public static void main(String[] args) {
//        这里可以使用匿名内部类，或者使用lambda表达式代替匿名内部类
        TextAnonymousInnerClass.doIt(new someOne() {
            @Override
            public void toDoSomething() {
                System.out.println("do it by anonymous inner class");
            }
        });
    }
}

interface someOne{
    void toDoSomething();
}
