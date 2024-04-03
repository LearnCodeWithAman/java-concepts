package lambda.methodReference;

public class RefDemo {

    public static void main(String[] args) {

        //provide the implementation of WorkInterface

        // 1. Lambda expression
        /*WorkInter workInter = () -> {
            System.out.println("This is do task new method");
        };
        workInter.doTask();*/

        // 2. Method Reference to static methods
        WorkInter workInter = Stuff::doStuff;
        workInter.doTask();

        Runnable runnable1 = Stuff::threadTask;
        Thread t = new Thread(runnable1);
        t.start();

        // 3. Method Reference to non-static methods
        Stuff ob = new Stuff();
        Runnable runnable2 = ob::printNumbers;
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}
