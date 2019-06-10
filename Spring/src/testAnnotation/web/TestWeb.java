package testAnnotation.web;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestWeb {
    @Test
    public void test1(){
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Servlet servlet1 = applicationContext.getBean("servlet", Servlet.class);
        Servlet servlet2 = applicationContext.getBean("servlet", Servlet.class);
        servlet1.doPost();
        System.out.println(servlet1);
        System.out.println(servlet2);
    }
}
