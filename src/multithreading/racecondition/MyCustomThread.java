package multithreading.racecondition;

public class MyCustomThread implements  Runnable{

    int shared = 0;
    @Override
    public void run() {
        for(int i=0; i<10000; i++) {
            shared++;
        }
    }

    public int getCount() {
        return shared;
    }
}
