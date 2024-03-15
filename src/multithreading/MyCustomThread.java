package multithreading;

public class MyCustomThread implements Runnable{


    @Override
    public void run() {
        System.out.println("Running - My Custom Thread: "+Thread.currentThread().getName());
    }
}
