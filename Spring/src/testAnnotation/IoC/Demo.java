package testAnnotation.IoC;

import org.springframework.stereotype.Component;

/**
 * @Component 注解用于取代xml中的<bean class="">标签
 *              在注解内写入参数表示对应的id
 * web开发有三个衍生注解（功能一致，名字不同）：
 *      @Repository：dao层
 *      @Service：service层
 *      @Controller：web层
 */
@Component("demoBeanAnnotationIoC")
public class Demo {
    public void doSomething(){
        System.out.println("do something!!!");
    }
}
