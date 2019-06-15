package testAOP.aspectJ.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect{

    // 切入点当前有效
//    @Before("execution(* testAOP.aspectJ.annotation.ServiceImpl.* (..))")
    public void before(JoinPoint joinPoint){
        System.out.println("before!");
    }

    // 声明公共的切入点
    @Pointcut("execution(* testAOP.aspectJ.annotation.ServiceImpl.* (..))")
    private void pointCut(){}

//    @AfterReturning(value = "pointCut()", returning = "rtn")
    public void afterReturning(JoinPoint joinPoint, Object rtn){
        System.out.println("afterReturning  --->" + rtn);
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("after");
        return obj;
    }

//    @AfterThrowing(value = "pointCut()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable){
        System.out.println("throw:" + throwable);
    }

//    @After(value = "pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("after");
    }

}
