package com.example.sefakkahriman.mvpdagger.di;

//module is gonna have dependencies we need
import com.example.sefakkahriman.mvpdagger.view.github.GithubPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class GithubModule  {

    //each method would return the dependency required
    @Provides
    GithubPresenter providesGithubPresenter(){
        return new GithubPresenter();
    }
}
