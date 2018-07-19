package com.example.sefakkahriman.mvpdagger.view.github;

import com.example.sefakkahriman.mvpdagger.view.base.BasePresenter;
import com.example.sefakkahriman.mvpdagger.view.base.BaseView;


//Contract is used for communicaiton
public interface GithubContract {

    // for communication from presenter to view
    interface View extends BaseView {
        void onValidationResults(String validName);

    }

    //for communication from view to presenter
    interface Presenter extends BasePresenter<View> {
        void validateName(String name);
    }
}
