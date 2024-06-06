package DOMAIN;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;

import APP.DB_ID;
//import APP.DTOMessage;
import APP.DTOUser;
import INF.Encryption;
import INF.RepositoryImp;

public class Service {
	public String maxID(String type) {
		Repository r = new RepositoryImp();
		return r.findMaxId(type);
	}

	public boolean userExists(String email) {
		Repository r = new RepositoryImp();
		if (r.findUser(email) == null) {
			return true;
		} else {
			return false;
		}
	}

	public void register(String username, String email, String encryptedStringPassword, String key) throws Exception {
		Service s = new Service();
		if (s.userExists(email)) {
			String maxID = s.maxID("user");
			int maxNumber = ID.cutNumber(maxID);
			Factory f = new Factory();
			DB_ID db_ID = new DB_ID("user", maxNumber);
			String password = Service.decrypt(key, encryptedStringPassword);
			User user = f.createUser(db_ID, username, email, password);
//			String key = Service.createKey();
//			Password encryptedStringPassword = f.createPassword(Service.encrypt(key, password));
			Repository r = new RepositoryImp();
			DTOUser dto_User = new DTOUser(user.getId(), user.getUsername(), user.getEmail(),
					f.createPassword(encryptedStringPassword), key);
			r.addUser(dto_User);
		}
	}

//	public void saveMessage(String sender, String receiver, String content) throws Exception {
//		Service s = new Service();
//		String maxID = s.maxID("message");
//		int maxNumber = ID.cutNumber(maxID);
//		Factory f = new Factory();
//		DB_ID dto_ID = new DB_ID("msgr", maxNumber);
//		String key = Service.createKey();
//		String encryptedStringContent = Service.encrypt(key, content);
//		Message message = f.createMessage(dto_ID, sender, receiver, encryptedStringContent);
//		Repository r = new RepositoryImp();
//		DTOMessage dto_Message = new DTOMessage(message.getId(), message.getSender(), message.getReceiver(),
//				encryptedStringContent, key);
//		r.addMessage(dto_Message);
//	}

	public boolean logIn(String username, String password) throws Exception {
		Repository r = new RepositoryImp();
		DTOUser dto_User = r.userExists(username);
		if (dto_User.equals(null)) {
			return false;
		} else {
			String decryptedStringPassword = decrypt(dto_User.getKey(), dto_User.getPassword().getPassWord());
			if (decryptedStringPassword.equals(password)) {
				return true;
			} else {
				return false;
			}
		}
	}

//	public List<String> reloadMessage(String sender, String receiver) throws Exception {
//		Repository r = new RepositoryImp();
//		List<DTOMessage> l_Message = r.messageExists(sender, receiver);
//		List<String> l_String = new ArrayList<String>();
//		for (DTOMessage dto_Message : l_Message) {
//			String decryptedStringMessage = decrypt(dto_Message.getKey(), dto_Message.getContent());
//			String message;
//			if (sender.equals(dto_Message.getSender())) {
//				message = sender + " :  " + decryptedStringMessage;
//				l_String.add(message);
//			} else if (sender.equals(dto_Message.getReceiver())) {
//				message = receiver + " :  " + decryptedStringMessage;
//				l_String.add(message);
//			}
//		}
//		return l_String;
//	}

	public static String createKey() throws Exception {
		return Encryption.generateKey(Encryption.generateKeyLength());
	}

	public static String encrypt(String key, String input) throws Exception {
		return Encryption.doCrypto(Cipher.ENCRYPT_MODE, key, input);
	}

	public static String decrypt(String key, String input) throws Exception {
		return Encryption.doCrypto(Cipher.DECRYPT_MODE, key, input);
	}
}
