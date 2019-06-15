package testAOP.aspectJ.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectJ {
    @Test
    public void test1(){
        String xmlPath = "testAOP/aspectJ/xml/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Service service = applicationContext.getBean("serviceAspectJ", Service.class);
        service.doSomething1();
        service.doSomething2();
        service.doSomething3();
    }
}
