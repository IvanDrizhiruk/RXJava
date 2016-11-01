package ua.dp.ardas.e2;

import rx.Observable;
import rx.Observer;


public class Operations_1 {

    public static void main(String[] args) {
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

        observable
                .skip(1)
                .take(2)
                .map(data -> "Mega " + data)
                .subscribe(
                        data -> System.out.println(data),
                        e -> e.printStackTrace(),
                        () -> System.out.println("=> complete"));
    }
}
