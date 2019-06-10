package testAOP.semiAuto;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //前置
        System.out.println("before!");
        //目标方法
        Object obj = methodInvocation.proceed();
        //后置
        System.out.println("after!");
        return obj;
    }
}
