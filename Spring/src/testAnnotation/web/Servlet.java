package testAnnotation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("servlet")
@Scope("prototype")
public class Servlet {
    @Autowired//属性注入，根据类型去匹配bean
    private Service service;

    public void doPost(){
        service.add();
    }
}
