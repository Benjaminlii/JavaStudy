package testInject.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
//    @Test
//    /**
//     * 原始的实例工厂
//     */
//    public void test1(){
//        //创建实例工厂
//        MyBeanFactory myBeanFactory = new MyBeanFactory();
//        Demo demo = myBeanFactory.createDemoImpl();
//        demo.demo();
//    }

    @Test
    /**
     * spring实例工厂
     */
    public void test2(){
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Demo demo = applicationContext.getBean("demoBeanFactory", Demo.class);
        demo.demo();
    }

}
