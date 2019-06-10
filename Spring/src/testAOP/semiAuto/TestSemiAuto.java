package testAOP.semiAuto;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSemiAuto {
    @Test
    public void test1(){
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Service service = applicationContext.getBean("proxyService", Service.class);
        service.doSomething1();
        service.doSomething2();
        service.doSomething3();
    }
}
