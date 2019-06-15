package testAnnotation.IoC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAnnotationIoC {
    @Test
    public void test1(){
        String xmlPath = "testAnnotation/IoC/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Demo demo = applicationContext.getBean("demoBeanAnnotationIoC", Demo.class);
        demo.doSomething();
    }
}
