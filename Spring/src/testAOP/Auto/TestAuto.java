package testAOP.Auto;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAuto {
    @Test
    public void test1(){
        String xmlPath = "testAOP/Auto/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Service service = applicationContext.getBean("serviceSpring", Service.class);
        service.doSomething1();
        service.doSomething2();
        service.doSomething3();
    }
}
