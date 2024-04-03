package multithreading.threadpool;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConcurrentFileReaderExample {

    public static void main(String[] args) {

        String file1path = "C:/Users/amanverma01/IdeaProjects/resources/samplelogs1.txt";
        String file2path = "C:/Users/amanverma01/IdeaProjects/resources/samplelogs2.txt";

        Thread t1 = new Thread(() -> readFile(file1path));
        Thread t2 = new Thread(() -> readFile(file2path));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " reads line " +line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
