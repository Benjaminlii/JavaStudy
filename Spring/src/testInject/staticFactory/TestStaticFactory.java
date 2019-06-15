package testInject.staticFactory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStaticFactory {
    @Test
    /**
     * 原始的静态工厂
     */
    public void test1(){
        Demo demo = MyBeanFactory.getDemo();
        demo.demo();
    }

    @Test
    /**
     * 使用Spring的完成静态工厂的使用
     */
    public void test2(){
        String xmlPath = "testInject/staticFactory/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Demo demo = applicationContext.getBean("demoBeanStaticFactory", Demo.class);
        demo.demo();
    }
}
