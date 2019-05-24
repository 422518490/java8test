package chpater11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author liaoyubo
 * @version 1.0
 * @date 2018/8/31
 * @description
 */
public class Shop {

    public double getPrice(String product){
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                future.complete(price);
            }catch (Exception ex){
                future.completeExceptionally(ex);
            }
        }).start();
        CompletableFuture.supplyAsync(() -> calculatePrice(product));
        return future;
    }

    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice(String product){
        delay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void main(String [] args){
        Shop shop = new Shop();

    }
}
