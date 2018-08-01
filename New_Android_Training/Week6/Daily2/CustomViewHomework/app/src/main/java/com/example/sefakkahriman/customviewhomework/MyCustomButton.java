package com.example.sefakkahriman.customviewhomework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;

public class MyCustomButton extends android.support.v7.widget.AppCompatButton {
    public static final String TAG = MyCustomButton.class.getSimpleName() + "_TAG";

    String imageUri;

    public MyCustomButton(Context context) {
        super(context);
        init(context, null, 0);
    }

    public MyCustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MyCustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void init(final Context context, @NonNull AttributeSet attrs, int defStyleRed) {

        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                openDiolog(context);
            }
        });

    }

    private void openDiolog(Context context) {

        FragmentActivity activity = (FragmentActivity) context;
        FragmentManager manager = activity.getSupportFragmentManager();
        SimpleDialog exampleDialog = new SimpleDialog();
        exampleDialog.show(manager, "simple dialog");
    }


    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

}
