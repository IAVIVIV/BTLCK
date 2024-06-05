package APP;

import DOMAIN.Email;
import DOMAIN.ID;
import DOMAIN.Password;

public class DTOUser {
	private ID id;
	private String username;
	private Email email;
	private Password password;
	private String key;

	public DTOUser(ID id, String username, Email email, Password password, String key) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.key = key;
	}

	public ID getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public Email getEmail() {
		return email;
	}

	public Password getPassword() {
		return password;
	}

	public String getKey() {
		return key;
	}
}
