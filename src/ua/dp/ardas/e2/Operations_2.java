package ua.dp.ardas.e2;

import rx.Observable;


public class Operations_2 {

    public static void main(String[] args) {

        Observable<String> observable = Observable.just("Java", "Javascript", "Co", "Guava", "C++");

        observable
                .filter(data -> data.contains("Java"))
                .doOnNext(data -> System.out.println("==> " + data))
                .flatMap(data -> Observable.from(data.split("")))
                .subscribe(data -> System.out.println(data));
    }
}
