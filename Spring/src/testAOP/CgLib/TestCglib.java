package testAOP.CgLib;

import org.junit.Test;

public class TestCglib {

    @Test
    public void test1(){
        ServiceImpl service = MyBeanFactory.createService();
        service.doSomething1();
        service.doSomething2();
        service.doSomething3();
    }
}
