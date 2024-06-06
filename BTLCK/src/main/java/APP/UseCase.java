package APP;

import DOMAIN.Service;

public class UseCase {
	public static void register(String username, String email, String encryptedStringPassword, String key)
			throws Exception {
		Service s = new Service();
		s.register(username, email, encryptedStringPassword, key);
	}

	public static void sendMessage(String sender, String receiver, String encryptedStringContent, String key)
			throws Exception {
		Service s = new Service();
		s.saveMessage(sender, receiver, encryptedStringContent, key);
	}
}
