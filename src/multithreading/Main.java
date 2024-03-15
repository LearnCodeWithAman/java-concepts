package multithreading;

public class Main {

    public static void main(String[] args) {

        MyCustomThread myCustomThread = new MyCustomThread();

        Thread t1 = new Thread(myCustomThread);
        t1.start();
        Thread t2 = new Thread(myCustomThread);
        t2.start();
    }
}
