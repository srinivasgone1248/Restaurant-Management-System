package HotBreads;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;



public class PasswordUtils {
	private static final int SALT_LENGTH = 16;
	private static final int ITERATIONS = 65536;
	private static final int KEY_LENGTH = 256;
	
	
	public static String generatesalt() {
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[SALT_LENGTH];
		sr.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}

	
public static String hashPassword(String password, String saltBase64) {
	
	try {
		byte[] salt = Base64.getDecoder().decode(saltBase64);
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(),salt, ITERATIONS, KEY_LENGTH);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte [] hash = skf.generateSecret(spec).getEncoded();
		return Base64.getEncoder().encodeToString(hash);
	}catch(Exception e) {
		throw new RuntimeException("error while hashing a password: "+ e.getMessage(), e);
	}
}
public static boolean verifyPassword(String password, String saltBase64, String expectedHashBase64) {
	String computedHash = hashPassword(password, saltBase64);
	return computedHash.equals(expectedHashBase64);
}
}
