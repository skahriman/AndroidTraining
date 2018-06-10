package com.example.sefakkahriman.demo;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {

    void inject(MainActivity mainActivity);

}
