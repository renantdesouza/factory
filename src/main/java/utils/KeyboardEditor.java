package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Create a keyboard to encrypt.
 *
 * @author renantdesouza.
 * @since 04/08/2016.
 */
public class KeyboardEditor {

    public KeyboardEditor() {
    }

    public static Map<String, String> getKeyboard() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 128; i++) {
            map.put(String.valueOf(i), Encryptor.encrypt(String.valueOf((char) i)));
        }
        return map;
    }

}