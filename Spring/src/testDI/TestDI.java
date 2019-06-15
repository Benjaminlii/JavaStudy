package testDI;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void test(){
        //获得spring容器
        String xmlPath = "testDI/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        //获得进行了依赖注入的bean对象
        Service service = (Service) applicationContext.getBean("service");
        service.demo();
    }
}
