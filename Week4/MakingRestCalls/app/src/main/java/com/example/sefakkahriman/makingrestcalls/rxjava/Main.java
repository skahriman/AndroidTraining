package com.example.sefakkahriman.makingrestcalls.rxjava;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) {
        //define observable

        List<Interger> integers = Arrays.asList(1,2,3,4,5);

        Observable<Integer> integerObservable =  Observable.just(1,2,3,4,5);

        Observer<Integer> integerObserver = new Observer() {
            @Override
            public void update(Observable o, Object arg) {

            }
        }
    }
}
