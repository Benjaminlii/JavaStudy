package testLifeCycle.testBeanPostProcessor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBeanPostProcessor {
    @Test
    public void test1() {
        String xmlPath = "testLifeCycle/testBeanPostProcessor/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Demo demo =  applicationContext.getBean("demoBeanPostProcessor", Demo.class);
        demo.doSomething();

    }
}
