package testAOP.Proxy;

public class ServiceImpl implements Service {
    @Override
    public void doSomething1() {
        System.out.println("do something fist!");
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
