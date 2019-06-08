package designMode.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarProxy implements InvocationHandler {
    private Object object;

    public StarProxy(Object object) {
        this.object = object;
    }

    //调用各个方法，使用了反射
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object rtn = method.invoke(object, args);
        after();
        return rtn;
    }

    //前置处理
    public void before() {
        System.out.println("联系经纪人");
    }

    //后置处理
    public void after() {
        System.out.println("明星分成");
    }

    //调度器，用于生成动态代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this);
    }
}
