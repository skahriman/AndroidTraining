package com.example.sefakkahriman.encryption.view.base;

import android.view.View;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void showEror();
}
