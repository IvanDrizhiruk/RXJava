package ua.dp.ardas.e1_simple;

import rx.Observable;


public class E2_ThrowException {

    public static void main(String[] args) {

        Observable<String> observable = Observable.create(subscriber -> {
            subscriber.onNext("Java");
            subscriber.onNext("Javascript");
            subscriber.onNext("Go");
            subscriber.onError(new UnknownError("Brainfuck code is not very friendly and readable."));
            subscriber.onCompleted();
        });

        observable.subscribe(
                data -> System.out.println(data),
                e -> e.printStackTrace(),
                () -> System.out.println("=> Complete"));
    }
}
