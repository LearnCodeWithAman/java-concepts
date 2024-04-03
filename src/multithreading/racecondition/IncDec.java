package multithreading.racecondition;

public class IncDec {

    static private int count = 0;
    static int n = 10000;

    public static void main(String[] args) {

        Runnable incrementTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<n; i++)
                    count++;
            }
        };

        Runnable decrementTask = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<n; i++)
                    count--;
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

        System.out.println("Final Count : " +count);
    }
}
