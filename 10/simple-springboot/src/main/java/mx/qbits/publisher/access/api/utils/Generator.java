package mx.qbits.publisher.access.api.utils;

import java.security.SecureRandom;

public class Generator {
    public static String getRandomString(int len) {
        char[] result = new char[len];
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for(int i =0; i<len; i++) {
            SecureRandom random = new SecureRandom();
            int num = random.nextInt(base.length());
            result[i] = base.charAt(num);
        }
        return new String(result);
    }
}
