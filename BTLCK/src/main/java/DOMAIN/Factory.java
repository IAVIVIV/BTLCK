package DOMAIN;

import APP.DB_ID;

public class Factory {
	public static boolean DEFAULT_BOOLEAN = false;

	public User createUser(DB_ID id, String username, String email, String password) {
		if (checkUser(email, password)) {
			ID idClone = createID(id);
			String usernameClone = username;
			Email emailClone = createEmail(email);
			Password passwordClone = new Password(password);
			User user = new User(idClone, usernameClone, emailClone, passwordClone);
			return user;
		} else {
			return null;
		}
	}

	public ID createID(DB_ID idOther) {
		ID id = ID.randomID(idOther.getIdOther(), idOther.getNumber());
		return id;
	}

	public ID create_ID(String id) {
		return new ID(id);
	}

	public Email createEmail(String email) {
		return new Email(email);
	}

	public Password createPassword(String password) {
		return new Password(password);
	}

//	public Message createMessage(DB_ID id, String sender, String receiver, String content) {
//		ID idClone = createID(id);
//		String senderClone = sender;
//		String receiverClone = receiver;
//		String contentClone = content;
//		return new Message(idClone, senderClone, receiverClone, contentClone);
//	}

	public boolean checkUser(String email, String password) {
		if (Email.isValidEmail(email) && Password.isValidPassWord(password)) {
			return !DEFAULT_BOOLEAN;
		} else {
			return DEFAULT_BOOLEAN;
		}
	}
}
