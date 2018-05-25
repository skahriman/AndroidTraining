package com.example.sefakkahriman.encryption;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Calendar;

import javax.security.auth.x500.X500Principal;

public class KeystoreManager
{
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    Context context;
    KeyStore keyStore;
    KeyPairGenerator keyPairGenerator;

    public static final String ALGORITHM = "RSA";

    public KeystoreManager(Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyStoreException {
        this.context = context;
        keyStore = KeyStore.getInstance(KEYSTORE_PROVIDER);
        keyStore.load(null);
    }

    //generate the keypair
    public KeyPair createKeyPair(String alias) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM, KEYSTORE_PROVIDER);

        //create key pair generator speification for adding the fake certification
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(context).setAlias(alias)
                .setSerialNumber(BigInteger.ONE)
                .setStartDate(startDate.getTime())
                .setSubject(new X500Principal("CN = {alias} CA Certification"))
                .setEndDate(endDate.getTime())
                .build();

        //init the keypair generator with the specification
        keyPairGenerator.initialize(spec);
        return  keyPairGenerator.generateKeyPair();
    }

    public KeyPair getKeyPair(String alias) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, NoSuchProviderException, InvalidAlgorithmParameterException {

        if (keyStore.getCertificate(alias) == null)
            createKeyPair(alias);

        PrivateKey privateKey = (PrivateKey)keyStore.getKey(alias, null);
        PublicKey publicKey = keyStore.getCertificate(alias).getPublicKey();
        if (privateKey != null && publicKey != null)
        {
            return  new KeyPair(publicKey, privateKey);
        }
        else
            return null;
    }

    public void removeKey(String alias) throws KeyStoreException {
        keyStore.deleteEntry(alias);
    }
}
