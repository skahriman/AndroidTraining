package com.example.sefakkahriman.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_SHARED_PREF = "mySharedPref";
    private TextView tvMain;
    private TextView etMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);
        etMain = findViewById(R.id.etMain);

    }

    public void handleSharedPreferences(View view) {
        SharedPreferences sharedPreferences =
                getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE);

        switch (view.getId()) {
            case R.id.btnSaveData:

                String etString = etMain.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("etMain", etString);
                //we can use editor.apply() also
                boolean isSaved = editor.commit();
                if (isSaved) {
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnGetData:

                String data = sharedPreferences
                        .getString("etMain", "default value");
                tvMain.setText(data);
                break;
        }
    }
}
