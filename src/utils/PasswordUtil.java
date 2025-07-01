package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    //fungsi untuk mengubah password menjadi hash menggunakan algoritma SHA-256
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            //mengubah password menjadi array byte dan hashing
            byte[] hashedBytes = md.digest(password.getBytes());
            //mengubah hasil byte ke format hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing gagal", e);
        }
    }
}
