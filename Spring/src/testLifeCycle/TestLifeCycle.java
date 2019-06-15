package testLifeCycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestLifeCycle {
    @Test
    public void test1(){
        String xmlPath = "testLifeCycle/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Demo demo = applicationContext.getBean("demoBeanInitDestroy", DemoImpl.class);
        demo.demo();

        //以反射的方式关闭容器
//        try {
//            applicationContext.getClass().getMethod("close").invoke(applicationContext);
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }
        //使用子类的close方法关闭容器
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
