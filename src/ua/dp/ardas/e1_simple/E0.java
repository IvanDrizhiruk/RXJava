package ua.dp.ardas.e1_simple;

import rx.Observable;
import rx.Observer;


public class E0 {

    public static void main(String[] args) {

        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("=> Completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getStackTrace());
            }

            @Override
            public void onNext(Object obj) {
                System.out.println(obj);
            }
        };

        Observable observable = Observable.just("Java", "Javascript", "C#", "Go", "Scala");

        observable.subscribe(observer);

    }
}
