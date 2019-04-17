package JavaSE.textMultithread;


class Employee implements Runnable {

    // ���Զ�����ThreadLocal��ÿһ��ThreadLocal������Thread.ThreadLocalMap�ж�Ӧһ��key-value��
    private static ThreadLocal<Integer> one = new ThreadLocal();

    public static void add(int n){
        one.set(one.get() + n);
    }

    @Override
    public void run() {
        one.set(0);
        for(int i = 0; i < 500; i++){
            Employee.add(1);
            System.out.println(Thread.currentThread().getName() + ":" + one.get() + " Thread.ThreadLocalMap = ");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TextThreadLocal {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Employee());
        Thread t2 = new Thread(new Employee());
        Thread t3 = new Thread(new Employee());

        t1.start();
        t2.start();
        t3.start();
    }
}
