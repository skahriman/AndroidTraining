package com.example.sefakkahriman.customviewhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    private MyCustomButton rectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rectangle = findViewById(R.id.myRectangleView);
        rectangle.setImageUri("https://www.google.com/search?biw=1379&bih=710&tbs=islt%3Aqsvga%2Cisz%3Aex%2Ciszw%3A240%2Ciszh%3A160&tbm=isch&sa=1&ei=p8xhW6GyGor85gL1s5yIAQ&q=image+small+size&oq=image+small+size&gs_l=img.3..0j0i5i30k1l4j0i8i30k1l4j0i24k1.6600.7213.0.7357.5.5.0.0.0.0.101.467.4j1.5.0....0...1c.1.64.img..0.5.466...0i30k1.0.melNCR5_vI0#imgrc=M770pPYuXzdvAM:");
    }
}
