package CryptoAsymmetric;

import javax.crypto.Cipher;
import java.security.*;

public class AsymmetricEncryptionUtils {

    private  static final String RSA = "RSA";

    public  static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
        keyPairGenerator.initialize(4096, secureRandom);
        return keyPairGenerator.generateKeyPair();
    }


    public static  byte [] performRSAEncryption(String plainText, PrivateKey privateKey) throws  Exception{
        Cipher cipher = Cipher.getInstance(RSA);
        //Encrypting with Private Key
        cipher.init(Cipher.ENCRYPT_MODE, privateKey );
       return cipher.doFinal(plainText.getBytes());
    }

    public static  String performRSADecryption(byte [] cipherText, PublicKey publicKey) throws  Exception{
        Cipher cipher = Cipher.getInstance(RSA);
        //Decrypting with Private Key
        cipher.init(Cipher.DECRYPT_MODE, publicKey );
        byte[] result = cipher.doFinal(cipherText);
        return new String(result);
    }
}