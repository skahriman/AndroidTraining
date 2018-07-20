package com.example.sefakkahriman.mvpdagger.view.base;

//this extends base view
public interface BasePresenter<V extends BaseView>{

    void attachView(V view);
    void detach();

}
