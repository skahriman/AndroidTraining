package com.example.sefakkahriman.encryption.di.module;


import com.example.sefakkahriman.encryption.view.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module(includes = EncryptionModule.class)
public class MainModule {

    @Provides
    MainPresenter providesMainPresenter() {
        return new MainPresenter();
    }
}
