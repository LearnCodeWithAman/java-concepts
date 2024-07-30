package multithreading.deadlock;

public class DeadlockDemo {

    public static void main(String[] args) {

        Object varsha_key = new Object();
        Object harsha_key = new Object();

        Thread varsha = new Thread(() -> {
            synchronized(harsha_key) {
                System.out.println("Varsha has accquired harsha's key");
                try {
                    System.out.println("Varsha sleeping for 3 mins");
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Varsha woke up");

                synchronized (varsha_key) {
                    System.out.println("Varsha has got her key");
                }
            }
        });

        Thread harsha = new Thread(() -> {
            synchronized(varsha_key) {
                System.out.println("Harsha has accquired varsha's key");
                try {
                    System.out.println("Harsha sleeping for 3 mins");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Harsha woke up");

                synchronized (harsha_key) {
                    System.out.println("Harsha has got her key");
                }
            }
        });

        harsha.start();
        varsha.start();

    }
}
