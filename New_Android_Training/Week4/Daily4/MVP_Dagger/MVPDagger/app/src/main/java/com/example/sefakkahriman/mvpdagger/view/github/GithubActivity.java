package com.example.sefakkahriman.mvpdagger.view.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.mvpdagger.R;
import com.example.sefakkahriman.mvpdagger.di.DaggerGithubCompenent;

import javax.inject.Inject;

public class GithubActivity extends AppCompatActivity implements GithubContract.View {

    private EditText etMain;
    private TextView tvMain;

    //inject the presenter instance  using @Inject as a target
    @Inject
    GithubPresenter presenter; // can not be private, dagger need to access it from outside

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);

//        presenter = new GithubPresenter(); // we don't need this since we use dagger

    }

    @Override
    protected void onStart() {
        super.onStart();
        DaggerGithubCompenent.create().inject(this);
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detach();
    }

    @Override
    public void onValidationResults(String validName) {
        tvMain.setText(validName);
    }



    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    public void onDisplayName(View view) {
        presenter.validateName(etMain.getText().toString());
    }
}
