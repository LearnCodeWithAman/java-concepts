package multithreading.threadpool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentFileReaderWithThreadPool {

    public static void main(String[] args) {

        String[] filePaths = {"C:/Users/amanverma01/IdeaProjects/resources/samplelogs1.txt",
                            "C:/Users/amanverma01/IdeaProjects/resources/samplelogs2.txt",
                            "C:/Users/amanverma01/IdeaProjects/resources/samplelogs3.txt"

        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(String filePath : filePaths)
            executorService.execute(() -> readFile(filePath));

        executorService.shutdown();

    }

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Thread.sleep(1000);
                System.out.println("File:" + filePath.substring(44) + " "
                        + Thread.currentThread().getName() + " reads line " +line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
