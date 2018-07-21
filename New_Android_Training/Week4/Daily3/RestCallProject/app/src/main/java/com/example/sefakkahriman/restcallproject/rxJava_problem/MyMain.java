package com.example.sefakkahriman.restcallproject.rxJava_problem;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MyMain {
    public static void main(String[] args)
    {
        Observable<Integer> integerObservable1 = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Observable<Integer> integerObservable2 = Observable.just(1,1,2,2,3,3,4,4,5);

        Observer<Integer> observer1 = new TestObservable();

        integerObservable1.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer;
            }
        }).takeLast(8).skip(1).take(6).subscribe(observer1);

        System.out.println();
        /////////////
        Observer<Integer> observer2 = new TestObservable();

        integerObservable2.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) throws Exception {
                return integer;
            }
        }).distinct().skipLast(2).mergeWith(integerObservable1).subscribe(observer2);



    }
    public static class TestObservable implements Observer<Integer>
    {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Integer integer) {
            System.out.println(integer);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}