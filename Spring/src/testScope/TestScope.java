package testScope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    @Test
    public void test1(){
        String xmlPath = "testScope/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Demo demo1 = applicationContext.getBean("demoBeanScope", Demo.class);
        Demo demo2 = applicationContext.getBean("demoBeanScope", Demo.class);
        System.out.println(demo1);
        System.out.println(demo2);

    }
}
