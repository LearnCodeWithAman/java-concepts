package multithreading.callablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureCodeDemo {

    public static void main(String[] args) {

        List<String> stockCodes = Arrays.asList(
                "TCS","INFY","WIPRO","MRF","ITC","HAL","BEL","BEML","MAZDOCK");
        List<Future> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(String stock : stockCodes) {
            StockPriceFetcherTask stockPriceFetcherTask = new StockPriceFetcherTask(stock);
            Future<Double> future = executorService.submit(stockPriceFetcherTask);
            System.out.println(future);
            futures.add(future);
        }
        executorService.shutdown();

        for(int i=0; i<stockCodes.size(); i++) {

            try {

                while(!futures.get(i).isDone()) {
                    System.out.println("Waiting . . .");
                    Thread.sleep(2000);
                }
                System.out.println("Price for Stock "+ stockCodes.get(i) +" = "+ futures.get(i).get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
