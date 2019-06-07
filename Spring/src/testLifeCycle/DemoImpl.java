package testLifeCycle;

public class DemoImpl implements Demo {
    @Override
    public void demo() {
        System.out.println("do demo!");
    }

    public void myInit(){
        System.out.println("do init");
    }

    public void myDestroy(){
        System.out.println("do destroy");
    }
}
