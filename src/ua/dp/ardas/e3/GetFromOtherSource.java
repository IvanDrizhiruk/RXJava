package ua.dp.ardas.e3;

import rx.Observable;

public class GetFromOtherSource {

    public static void main(String[] args) {

        Observable<String> observable1 = Observable.create(subscriber -> {
            subscriber.onNext("Lisp");
            subscriber.onNext("Assembler");
            subscriber.onNext("Fortran");
            subscriber.onError(new UnknownError("Brainfuck code is not very friendly and readable."));
            subscriber.onCompleted();
        });

        Observable<String> observable2 = Observable.just("Java", "Javascript", "C#", "Go", "Scala");

        observable1
                .doOnError(e -> System.out.println("*** " + e.getMessage()))
                .retry(3)
                .doOnError(e -> System.out.println("*** After retry"))
                .onErrorResumeNext(err -> {
                    System.out.println(" ==> Switching to an alternative data source because of : " + err.getMessage());

                    return observable2;
                })
                .subscribe(
                        data -> System.out.println(data),
                        e -> e.printStackTrace(),
                        () -> System.out.println("=> Complete"));
    }
}
