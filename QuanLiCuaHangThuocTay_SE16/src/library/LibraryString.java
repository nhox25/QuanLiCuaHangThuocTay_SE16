package library;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryString {

    public static String md5(String input) {
        String result = input;
        MessageDigest md = null;
        if (input != null) {
            try {
                md = MessageDigest.getInstance("MD5"); //or "SHA-1"
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LibraryString.class.getName()).log(Level.SEVERE, null, ex);
            }
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            result = hash.toString(16);
            while (result.length() < 32) { //40 for SHA-1
                result = "0" + result;
            }
        }
        return result;
    }

    public static boolean isPassword(String password) {
        String regex = "^[a-zA-Z]([a-zA-Z0-9!@#$%^&]{5,29})";
        return password.matches(regex);
    }

}
