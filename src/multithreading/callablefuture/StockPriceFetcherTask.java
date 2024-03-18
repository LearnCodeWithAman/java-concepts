package multithreading.callablefuture;

import java.util.concurrent.Callable;

public class StockPriceFetcherTask implements Callable {

    String stockCode;
    public StockPriceFetcherTask(String stockCode){
        this.stockCode = stockCode;
    }
    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return Math.random()*10000;
    }
}
