import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AESFileEncryption {
    public static void main(String[] args) throws Exception {
        String textFilePath = "src/plaintext.txt";
        String keyFilePath = "src/aeskey.key";  // Oder verwenden Sie den vollständigen Pfad hier
        String encryptedFilePath = "encryptedfile.enc";

        // Read key from file
        byte[] keyBytes = Files.readAllBytes(Paths.get(keyFilePath));
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        // Read text file
        byte[] textBytes = Files.readAllBytes(Paths.get(textFilePath));

        // Encrypt
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(textBytes);

        // Write encrypted bytes to file
        try (FileOutputStream fos = new FileOutputStream(encryptedFilePath)) {
            fos.write(encryptedBytes);
        }
    }
}
