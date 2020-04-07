package com.exmaple.android.loadingimagewityasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static String IMAGE_PATH = "http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
    ImageView mImageView;
    Button downlaodBtn;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.iv_image);
        downlaodBtn = findViewById(R.id.btn_button);

        downlaodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader().execute(IMAGE_PATH);
            }
        });
    }

    private class Downloader extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Image Downloader");
            mProgressDialog.setMessage("Downloading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String myString = strings[0];
            Bitmap bm = null;

            try {
                InputStream is = new URL(myString).openStream();
                bm = BitmapFactory.decodeStream(is);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bm;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mImageView.setImageBitmap(bitmap);
            mProgressDialog.dismiss();
        }
    }
}
