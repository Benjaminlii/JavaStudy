package JavaSE.textMultithread;

/**
 * 测试java中的单例模式，以及与之相关的线程安全问题的解决方式
 * 单例模式就是一个类只会产生一个对象，并且每次要使用需要通过类中的get方法得到该对象
 * 这种设计模式适用于一些特殊情况，如：售票机器的展示页面，虽然售票的机器可以有多个对象来实现卖票的功能
 * 但是要展示票的余量，就只能使用一个对象，因为所有的机器都应该显示同一个展示页面，多个对象会造成资源的浪费
 *
 * 延迟加载单例设计模式的线程安全处理时重点
 *
 * author:Benjamin
 * date:2018.12.13
 */
public class TextSingleton {
}

/**
 * 懒汉式（延迟加载单例设计模式）：
 *      在需要返回对象时才会判断进行对象的创建
 *      这种方式往往加载类比较块，但是获得对象的效率比较低
 */
class Single0{
    private static Single0 one = null;
    private Single0(){}
    public static Single0 getInstance(){
        if (Single0.one == null)
            one = new Single0();
        return one;
    }
}

/**
 * 懒汉式的线程安全处理
 * 由于多线程运行单例模式时，肯定会有共享数据，就肯定会有线程安全问题
 * 通过同步代码块解决线程安全问题并且在锁定线程之前进行一次判断，避免不必要的线程锁定，以提高效率
 *
 * 这种单例模式使用的比较多，可以比较好的解决线程安全问题
 * 敲黑板！！！
 */
class Single0_{
    private static Single0_ one = null;
    private Single0_(){}
    public static Single0_ getInstance(){
        // 解决效率问题，如果已经存在one对象，则不需要进行锁定线程
        if(Single0_.one == null) {
            // 解决线程安全问题
            // 单例设计模式的getInstance方法是静态的，没有this对象
            // 所以使用 类名.class 来找到类对象进行线程的锁定
            synchronized (Single0_.class) {
                // 在one创建之初的线程运行中保证线程的安全问题
                if (Single0_.one == null)
                    one = new Single0_();
            }
        }
        return one;
    }
}

/**
 * 饿汉式（单例设计模式）：
 *      在类加载时就会创建单例对象
 *      这种方式往往加载类比较满，但是获得对象的效率高
 */
class Single1{
    private static Single1 one = new Single1();
    private Single1(){}
    public static Single1 getInstance(){
        return one;
    }
}
