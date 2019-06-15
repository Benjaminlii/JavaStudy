package testAOP.aspectJ.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect{

    public void before(JoinPoint joinPoint){
        System.out.println("before!");
    }

    public void afterReturning(JoinPoint joinPoint, Object rtn){
        System.out.println("afterReturning  --->" + rtn);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("after");
        return obj;
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("throw:" + throwable);
    }

    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }

}
