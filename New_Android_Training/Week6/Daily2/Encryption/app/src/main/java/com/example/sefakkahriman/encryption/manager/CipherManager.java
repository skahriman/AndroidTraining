package com.example.sefakkahriman.encryption.manager;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CipherManager {

    public static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";

    Cipher cipher;

    public CipherManager() throws NoSuchPaddingException, NoSuchAlgorithmException {
        cipher = Cipher.getInstance(TRANSFORMATION);
    }

    public String encrypt(String plainText, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.encodeToString(encryptedBytes, Base64.DEFAULT);
    }

    public String decrypt(String cipherText, Key key) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] encryptedBytes = Base64.decode(cipherText, Base64.DEFAULT);
        byte[] plainBytes = cipher.doFinal(encryptedBytes);
        return  new String(plainBytes);
    }
}
