package com.example.sefakkahriman.mvpdagger.view.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sefakkahriman.mvpdagger.R;

public class GithubActivity extends AppCompatActivity implements GithubContract.View {

    private EditText etMain;
    private TextView tvMain;
    private GithubPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);

        presenter = new GithubPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
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
