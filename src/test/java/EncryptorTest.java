import utils.Encryptor;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by renan on 03/08/2016.
 */
public class EncryptorTest {

    @Test
    public void encryptorTest() {
        String test = "Renan";

        String encrypted = Encryptor.encrypt(test);
        Assert.assertNotEquals(encrypted, test);

        String decrypted = Encryptor.decrypt(encrypted);
        Assert.assertEquals(decrypted, test);

        System.out.println("original: " + test);
        System.out.println("encrypted: " + encrypted);
        System.out.println("decrypted: " + decrypted);
    }

}
