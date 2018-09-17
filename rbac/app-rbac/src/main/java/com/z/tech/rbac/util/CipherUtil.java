package com.z.tech.rbac.util;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class CipherUtil {

    private static final String PBE_WITH_MD_5_AND_DES = "PBEWithMD5AndDES";
    private static final byte[] PASSWORD_SALT = "20131122".getBytes();
    private static final int ITERATION_COUNT = 1000;

    public static String doEncrypt(String passwordPlain, String passwordKey) {
        try {
            Cipher cipher = Cipher.getInstance(PBE_WITH_MD_5_AND_DES);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PBE_WITH_MD_5_AND_DES);
            PBEKeySpec keySpec = new PBEKeySpec(passwordKey.toCharArray());
            SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
            PBEParameterSpec parameterSpec = new PBEParameterSpec(PASSWORD_SALT, ITERATION_COUNT);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
            byte[] bytes = cipher.doFinal(passwordPlain.getBytes());
            return bytes2HexString(bytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "-1";
    }

    private static String bytes2HexString(byte[] src) {
        if (src == null || src.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : src) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                sb.append(0);
            }
            sb.append(hv);
        }
        return sb.toString();
    }
}
