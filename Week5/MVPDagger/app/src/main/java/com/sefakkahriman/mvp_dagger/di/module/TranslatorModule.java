package com.sefakkahriman.mvp_dagger.di.module;

import com.sefakkahriman.mvp_dagger.utils.base.Translater;

import dagger.Module;
import dagger.Provides;

@Module
public class TranslatorModule {

    @Provides
    TranslaterPresenter providesTransltorPresenter() {
        return new TranslaterPresenter();
    }
}
