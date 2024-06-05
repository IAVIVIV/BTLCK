package DOMAIN;

import INF.Format;

public class Email {
	private String email;

	public Email(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public static boolean isValidEmail(String email) {
		return Format.formatEmail(email);
	}
}
