package lambda.methodReference;

import java.time.LocalDateTime;

public class Stuff {

    public static void doStuff() {
        System.out.println("I am doing task");
        System.out.println(LocalDateTime.now().toString());
    }

    public static void threadTask() {

        for(int i=0; i<=10; i++) {
            System.out.println(i*2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printNumbers() {

        for(int i=0; i<=10; i++) {
            System.out.println(i*2);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
