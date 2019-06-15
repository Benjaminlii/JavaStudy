package testXml.collection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestData {
    @Test
    public void test1(){
        String xmlPath = "testXml/collection/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Data data = applicationContext.getBean("dataBeanCollection", Data.class);
        System.out.println(data);
    }
}
