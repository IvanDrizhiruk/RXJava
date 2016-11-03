package ua.dp.ardas.e2;

import rx.Observable;


public class Operations_1 {

    public static void main(String[] args) {
        Observable<String> observable = Observable
                .just("C", "C++", "Java", "Python", "Go");

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
