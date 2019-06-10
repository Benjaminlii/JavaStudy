package testAOP.Proxy;

import org.junit.Test;

public class TestProxy {

    @Test
    public void test1(){
        Service service = MyBeanFactory.createService();
        service.doSomething1();
        service.doSomething2();
        service.doSomething3();
    }
}
