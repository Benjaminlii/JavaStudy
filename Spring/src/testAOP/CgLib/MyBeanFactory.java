package testAOP.CgLib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyBeanFactory {
    /**
     * 生成代理类对象
     */
    public static testAOP.CgLib.ServiceImpl createService(){
        // 目标类
        ServiceImpl service = new ServiceImpl();

        //切面类
        MyAspect myAspect = new MyAspect();

        // 代理类，使用Cglib，创建的是目标类的子类
        //Cglib的核心类
        Enhancer enhancer = new Enhancer();

        //设置父类，也就是目标类
        enhancer.setSuperclass(service.getClass());

        /**
         * 设置回调函数，MethodInterceptor接口 等效 jdk InvocationHandler接口
         *  intercept() 等效 jdk  invoke()
         *  	参数1、参数2、参数3：以invoke一样
         * 	    参数4：methodProxy 方法的代理
         */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //前置
                myAspect.before();
                //执行目标方法
//                Object obj = method.invoke(service, objects);
                Object obj = methodProxy.invokeSuper(o, objects);
                //后置
                myAspect.after();
                return o;
            }
        });

        //生成代理对象
        ServiceImpl cglib = (ServiceImpl) enhancer.create();

        return cglib;
    }
}
