package DOMAIN;

public class User {
	private ID id;
	private String username;
	private Email email;
	private Password password;

	public User(ID id, String username, Email email, Password password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
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

	public void setPassword(Password password) {
		this.password = password;
	}
}
