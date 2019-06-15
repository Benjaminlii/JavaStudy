package testAOP.aspectJ.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectJ {
    @Test
    public void test1(){
        String xmlPath = "testAOP/aspectJ/annotation/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Service service = applicationContext.getBean("serviceAspectJAnnotation", Service.class);
        service.doSomething1();
        service.doSomething2();
        service.doSomething3();
    }
}
