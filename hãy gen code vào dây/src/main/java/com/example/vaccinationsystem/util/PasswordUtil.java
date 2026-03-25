package com.example.vaccinationsystem.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordUtil {
    private PasswordUtil() {
    }

    /**
     * Hash theo logic giống DBProvider.cs mẫu:
     * MD5(pass) -> hexLower(string) -> SHA1(hexLower) -> hexLower.
     */
    public static String hashPass(String pass) {
        if (pass == null) return null;
        try {
            byte[] md5 = MessageDigest.getInstance("MD5").digest(pass.getBytes(StandardCharsets.US_ASCII));
            String md5Hex = toHexLower(md5);
            byte[] sha1 = MessageDigest.getInstance("SHA-1").digest(md5Hex.getBytes(StandardCharsets.US_ASCII));
            return toHexLower(sha1);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Missing hash algorithm", e);
        }
    }

    private static String toHexLower(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

