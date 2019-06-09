package testInject.staticFactory;

public class MyBeanFactory {
    /**
     * 静态工厂
     * @return 工厂生产的实例对象
     */
    public static Demo getDemo(){
        return new DemoImpl();
    }
}
