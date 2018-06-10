package com.example.sefakkahriman.dagger2demo.di;

import com.example.sefakkahriman.dagger2demo.MainActivity;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {

    void inject(MainActivity target);
}
