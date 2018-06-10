package com.example.sefakkahriman.demo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class MyModule {

    @Provides
    public MyDate provideMyDate(){
        return new MyDateImpl();
    }
}
