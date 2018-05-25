package com.example.sefakkahriman.encryption;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class MainActivity extends AppCompatActivity {
    EditText etPlainText;
    Button btConvertToCipher;
    TextView tvCipherText;
    Button btnConvertToPlain;
    TextView tvPlainText;

    KeystoreManager keystoreManager;
    CipherManager cipherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlainText = findViewById(R.id.etPlainText);
        btnConvertToPlain = findViewById(R.id.btnConvertToPlain);
        tvCipherText = findViewById(R.id.tvCipherText);
        btnConvertToPlain = findViewById(R.id.btnConvertToPlain);
        tvPlainText = findViewById(R.id.tvPlainText);

        try {
            initManagers();
        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException | NoSuchPaddingException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }


    }

    void initManagers() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, NoSuchPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {

        keystoreManager = new KeystoreManager(this);
        //keystoreManager.createKeyPair("something");
        cipherManager = new CipherManager();
    }



    public void onViewClicked(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException, NoSuchAlgorithmException, UnrecoverableKeyException, InvalidAlgorithmParameterException, KeyStoreException, NoSuchProviderException {
        KeyPair keyPair = keystoreManager.getKeyPair("something");

        switch (view.getId()) {
            case R.id.btConvertToCipher:
                String encryptedData = cipherManager.encrypt(etPlainText.getText().toString(), keyPair.getPublic());
                tvCipherText.setText(encryptedData);
                break;
            case R.id.btnConvertToPlain:
                String decryptedData = cipherManager.decrypt(tvCipherText.getText().toString(), keyPair.getPrivate());
                tvPlainText.setText(decryptedData);
                break;
        }
    }
}
