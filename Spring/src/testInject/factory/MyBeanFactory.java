package testInject.factory;

public class MyBeanFactory {
    /**
     * 实例工厂
     * @return 工厂生产的实例对象
     */
    public Demo getDemo(){
        return new DemoImpl();
    }
}
