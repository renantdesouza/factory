package utils;

import java.math.BigInteger;

/**
 * Create a cryptograph using two keys.
 *
 * @author renantdesouza.
 * @since 03/08/2016.
 */
public class Encryptor {

    private static final BigInteger KEY_1 = new BigInteger("867819071132");
    private static final BigInteger KEY_2 = new BigInteger("2305843008139952128");
    private static final String SPLITTER = "312343244230000432";

    public static String encrypt(String str) {
        StringBuilder encrypted = new StringBuilder();

        char[] letters = str.toCharArray();
        int length = letters.length;

        for (char letter : letters) {
            BigInteger len = new BigInteger(String.valueOf(length--));
            encrypted.append(new BigInteger(String.valueOf((int) letter)).multiply(KEY_1).multiply(KEY_2).multiply(len)).append(SPLITTER);
        }
        return encrypted.toString();
    }

    public static String decrypt(String str) {
        StringBuilder decrypt = new StringBuilder();

        String[] letters = str.split(SPLITTER);
        int length = letters.length;

        for (String letter : letters) {
            BigInteger len = new BigInteger(String.valueOf(length--));
            decrypt.append((char) new BigInteger(letter).divide(KEY_2).divide(KEY_1).divide(len).intValue());
        }
        return decrypt.toString();
    }

}
