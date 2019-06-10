package testAOP.Auto;

public class ServiceImpl implements Service {
    @Override
    public void doSomething1() {
        System.out.println("do something first!");
    }

    @Override
    public void doSomething2() {
        System.out.println("do something second!");
    }

    @Override
    public void doSomething3() {
        System.out.println("do something third!");
    }
}
