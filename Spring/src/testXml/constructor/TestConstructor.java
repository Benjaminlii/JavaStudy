package testXml.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {
    @Test
    public void test1(){
        String xmlPath = "testXml/constructor/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Student student = applicationContext.getBean("studentConstructor", Student.class);
        System.out.println(student);
    }
}
