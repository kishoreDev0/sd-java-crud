package com.ta.crud.Utilities.Functions;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;

import java.util.Base64;


public class AESUtil {

    @Value("${saltKey}")
    private static String saltKey ;

    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(saltKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(saltKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decoded));
    }
}
