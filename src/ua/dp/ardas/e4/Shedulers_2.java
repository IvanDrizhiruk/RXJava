package ua.dp.ardas.e4;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

public class Shedulers_2 {

    public static void main(String[] args) {

        List<String> datas = Arrays.asList("Java", "Javascript", "C#", "Go", "Scala");

        Observable.from(datas)
                .doOnNext(data -> printThreadNameForDoOnNext(data))
                .flatMap(data -> Observable.just(data)
                                .subscribeOn(Schedulers.computation())
                                .map(dataForPrint -> printThreadNameForSubscribe(dataForPrint))
                )
                .subscribe(dataForPrint -> printThreadNameForObserve(dataForPrint));

        sleep(7000);
    }

    private static void printThreadNameForDoOnNext(String data) {
        System.out.println("doOnNext" + data +" ==> " + Thread.currentThread().getName());
    }

    private static String printThreadNameForSubscribe(String data) {
        System.out.println("Subscribe " + data +" ==> " + Thread.currentThread().getName());

        sleep(500);

        return data;
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
