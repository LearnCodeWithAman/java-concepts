package multithreading.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeIncDec {

    static AtomicInteger counter = new AtomicInteger(0);
    static int n = 10000;

    public static void main(String[] args) {

        //AtomicInteger counter = new AtomicInteger(0);
        Runnable incrementTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<n; i++)
                    counter.incrementAndGet();
            }
        };

        Runnable decrementTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<n; i++)
                    counter.decrementAndGet();
            }
        };

        Thread increment = new Thread(incrementTask);
        Thread decrement = new Thread(decrementTask);

        increment.start();
        decrement.start();

        try {
            increment.join();
            decrement.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final Count : " + counter.get());
    }
}
