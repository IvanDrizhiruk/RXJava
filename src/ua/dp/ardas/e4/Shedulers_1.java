package ua.dp.ardas.e4;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

public class Shedulers_1 {

    public static void main(String[] args) {

        List<String> datas = Arrays.asList("Java", "Javascript", "C#", "Go", "Scala");
        Observable.from(datas)
                .subscribeOn(Schedulers.io())
                .doOnNext(data -> printThreadNameForSubscribe(data))
                .observeOn(Schedulers.computation())
                .subscribe(data -> printThreadNameForObserve(data));

        sleep(7000);

    }

    private static void printThreadNameForSubscribe(String data) {
        System.out.println("Subscribe " + data +" ==> " + Thread.currentThread().getName());
        sleep(1000);
    }

    private static void printThreadNameForObserve(String data) {
        System.out.println("Observe " + data +" ==> " + Thread.currentThread().getName());
        sleep(500);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
