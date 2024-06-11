import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class FileHashing {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String textFilePath = "src/plaintext.txt";

        byte[] textBytes = Files.readAllBytes(Paths.get(textFilePath));

        // MD5 Hash
        byte[] md5Hash = hash(textBytes, "MD5");
        Files.write(Paths.get("md5hash.txt"), md5Hash);

        // SHA-3 Hash
        byte[] sha3Hash = hash(textBytes, "SHA3-256");
        Files.write(Paths.get("sha3hash.txt"), sha3Hash);

        // RIPEMD-160 Hash
        byte[] ripemd160Hash = hash(textBytes, "RIPEMD160");
        Files.write(Paths.get("ripemd160hash.txt"), ripemd160Hash);
    }

    public static byte[] hash(byte[] input, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        return digest.digest(input);
    }
}

