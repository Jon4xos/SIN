import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AESFileDecryption {
    public static void main(String[] args) throws Exception {
        String encryptedFilePath = "encryptedfile.enc";
        String keyFilePath = "src/aeskey.key";
        String decryptedFilePath = "decryptedfile.txt";

        // Read key from file
        byte[] keyBytes = Files.readAllBytes(Paths.get(keyFilePath));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        // Read encrypted file
        byte[] encryptedBytes = Files.readAllBytes(Paths.get(encryptedFilePath));

        // Decrypt
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Write decrypted bytes to file
        try (FileOutputStream fos = new FileOutputStream(decryptedFilePath)) {
            fos.write(decryptedBytes);
        }
    }
}
