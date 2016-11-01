package ua.dp.ardas.e1_simple;

import rx.Observable;
import rx.Observer;


public class Simple1 {

    static Observer observer = new Observer() {
        @Override
        public void onCompleted() {
            System.out.println("Completed");
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println(throwable.getStackTrace());
        }

        @Override
        public void onNext(Object obj) {
            System.out.println("Thread " + Thread.currentThread().getId());
            System.out.println(obj);
        }
    };

    public static void main(String[] args) {
        completed();
//        faild();
//        infinite();

    }

    private static void completed() {
        Observable observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(observer);
        observable.subscribe(observer);
        observable.subscribe(observer);
    }

    private static void faild() {
        Observable observable = Observable.create(subscriber -> {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onNext(3);
            subscriber.onError(new UnknownError("Something go wrong"));
        });

        observable.subscribe(observer);
    }

    private static void infinite() {
        Observable observable = Observable.create(subscriber -> {
            subscriber.onNext(1);
            subscriber.onNext(2);
            subscriber.onNext(3);
        });

        observable
                .subscribe(observer);
    }
}
