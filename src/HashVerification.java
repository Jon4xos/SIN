import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;

public class HashVerification {
    public static void main(String[] args) throws Exception {
        String textFilePath = "src/plaintext.txt";
        String hashFilePath = "md5hash.txt";
        String algorithm = "MD5";

        byte[] textBytes = Files.readAllBytes(Paths.get(textFilePath));
        byte[] storedHash = Files.readAllBytes(Paths.get(hashFilePath));

        byte[] calculatedHash = hash(textBytes, algorithm);

        if (Arrays.equals(storedHash, calculatedHash)) {
            System.out.println("Hash verification successful.");
        } else {
            System.out.println("Hash verification failed.");
        }
    }

    public static byte[] hash(byte[] input, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        return digest.digest(input);
    }
}

