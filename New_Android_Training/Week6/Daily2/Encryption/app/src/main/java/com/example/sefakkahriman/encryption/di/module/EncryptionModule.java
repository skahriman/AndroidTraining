package com.example.sefakkahriman.encryption.di.module;

import android.content.Context;

import com.example.sefakkahriman.encryption.manager.CipherManager;
import com.example.sefakkahriman.encryption.manager.KeystoreManager;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.crypto.NoSuchPaddingException;

import dagger.Module;
import dagger.Provides;

@Module
public class EncryptionModule {

    @Provides
    KeystoreManager providesKeyStoreManager(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        return new KeystoreManager(context);
    }

    @Provides
    CipherManager providesCihperManager() throws NoSuchAlgorithmException, NoSuchPaddingException {
        return new CipherManager();
    }



}
