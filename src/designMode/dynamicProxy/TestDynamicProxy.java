package designMode.dynamicProxy;

import org.junit.Test;

public class TestDynamicProxy {

    @Test
    public void test1(){
        Person star = new Star();
        StarProxy starProxy = new StarProxy(star);

        Person men = (Person) starProxy.getProxyInstance();
        men.work();
    }
}
