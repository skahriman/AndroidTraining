package com.example.sefakkahriman.butterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.titleTextView)
    TextView titleTextView;
    @BindView(R.id.subTitleTextView)
    TextView subTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        titleTextView.setText("This is title");
        subTitleTextView.setText("This is subtitle");
    }


    @OnClick({R.id.backButton, R.id.nextButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButton:
                Toast.makeText(this, "back clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nextButton:
                Toast.makeText(this, "next clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
