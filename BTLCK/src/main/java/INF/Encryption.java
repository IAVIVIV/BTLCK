package INF;

import java.util.Base64;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES";

	public static String generateKey(int n) throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
		keyGen.init(n);
		SecretKey secretKey = keyGen.generateKey();
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
	}

	public static String doCrypto(int cipherMode, String key, String input) throws Exception {
		SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(key), ALGORITHM);
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		cipher.init(cipherMode, secretKey);
		byte[] outputBytes = cipherMode == Cipher.ENCRYPT_MODE ? cipher.doFinal(input.getBytes())
				: cipher.doFinal(Base64.getDecoder().decode(input));
		return cipherMode == Cipher.ENCRYPT_MODE ? Base64.getEncoder().encodeToString(outputBytes)
				: new String(outputBytes);
	}

	public static int generateKeyLength() {
		Random random = new Random();
		int[] validKeyLengths = { 128, 192, 256 };
		return validKeyLengths[random.nextInt(validKeyLengths.length)];
	}
}
