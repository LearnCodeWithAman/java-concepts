package multithreading.synchronization;
public class BankDemo {

    private long balance;

    public BankDemo(long initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(long amount) {

        long newBalance = balance + amount;
        // simulating some processing time
        System.out.println(Thread.currentThread().getName()+ " is running with balance= " +newBalance);
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance;
    }

    public void withdraw(long amount) {

        long newBalance = balance - amount;
        System.out.println(Thread.currentThread().getName()+ " is running with balance= " +newBalance);
        // simulating some processing time
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance;
    }

    public long getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        BankDemo account = new BankDemo(100);

        Thread deposit1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(40);

            }
        }, "deposit1");

        Thread deposit2 = new Thread(() -> account.deposit(50), "deposit2");
        Thread withdraw1 = new Thread(() -> account.withdraw(30), "withdraw1");
        Thread withdraw2 = new Thread(() -> account.withdraw(50), "withdraw2");



        deposit1.start();
        deposit2.start();
        withdraw1.start();
        withdraw2.start();

        try {
            deposit1.join();
            deposit2.join();
            withdraw1.join();
            withdraw2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance : " +account.getBalance());
    }
}

