package testAOP.aspectJ;

public class ServiceImpl implements Service {
    @Override
    public void doSomething1() {
        System.out.println("do something first!");
    }

    @Override
    public String doSomething2() {
        System.out.println("do something second!");
        return "rtn";
    }

    @Override
    public void doSomething3() {
        System.out.println("do something third!");
    }
}
