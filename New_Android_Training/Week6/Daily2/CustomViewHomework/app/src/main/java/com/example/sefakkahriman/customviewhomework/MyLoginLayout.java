package com.example.sefakkahriman.customviewhomework;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MyLoginLayout extends LinearLayout {

    Context context;
    LayoutInflater inflater;

    private static final String MY_SHARED_PREF = "mySharedPref";

    public MyLoginLayout(Context context) {
        super(context);

        init(context);
    }

    public MyLoginLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public MyLoginLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyLoginLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(final Context context) {

        final SharedPreferences sharedPreferences =
                context.getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE);

        final EditText etEmail;
        final EditText etPassword;
        Button btnRegister;
        Button btnLogin;

        this.context = context;
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_login_layout, this, true);

        etEmail = view.findViewById(R.id.etUserEmail);
        etPassword = view.findViewById(R.id.etPassword);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnLogin = view.findViewById(R.id.btnLogin);

//        region login
        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email);
                editor.putString("password", password);

                //we can use editor.apply() also
                boolean isSaved = editor.commit();
                if (isSaved) {
                    Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //endregion

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = sharedPreferences.getString("email", "default value");
                String password = sharedPreferences.getString("password", "default value");


                if ((etEmail.getText().toString().equals(email)) && etPassword.getText().toString().equals(password)){
                    context.startActivity(new Intent(context, LoginActivity.class));
                }
                else
                    Toast.makeText(context, "Wrong email/password", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
