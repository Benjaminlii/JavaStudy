package testXml.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSetter {
    @Test
    public void test1(){
        String xmlPath = "testXml/setter/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Person person = applicationContext.getBean("personBeanSetter", Person.class);
        System.out.println(person);
    }
}
