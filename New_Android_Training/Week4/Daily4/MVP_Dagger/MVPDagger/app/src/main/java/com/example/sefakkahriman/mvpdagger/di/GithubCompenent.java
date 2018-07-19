package com.example.sefakkahriman.mvpdagger.di;


import com.example.sefakkahriman.mvpdagger.view.github.GithubActivity;
import com.example.sefakkahriman.mvpdagger.view.github.GithubPresenter;

import dagger.Component;

//contract for dependencies and dependent
@Component(modules = GithubModule.class)
public interface GithubCompenent {

    void inject(GithubActivity activity);

}
