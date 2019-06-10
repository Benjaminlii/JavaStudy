package testAOP.CgLib;

public class MyAspect {
    public void after(){
        System.out.println("after!");
    }

    public void before(){
        System.out.println("before!");
    }
}
