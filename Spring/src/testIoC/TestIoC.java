package testIoC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
    @Test
    /**
     * 测试从Spring容器获得实例对象
     */
    public void test1(){
        // 获得容器
        String xmlPath = "testIoC/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        //获取实例对象
        DemoImpl demo = (DemoImpl) applicationContext.getBean("demoBean");
        demo.demo();
    }
}
