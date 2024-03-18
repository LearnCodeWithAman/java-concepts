package multithreading.racecondition;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyCustomThread customThread = new MyCustomThread();

        Thread t1 = new Thread(customThread);
        Thread t2 = new Thread(customThread);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Value of Shared Counter : " + customThread.getCount());

    }
}
