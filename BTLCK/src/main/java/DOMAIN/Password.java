package DOMAIN;

import INF.Format;

public class Password {
	private String passWord;

	public Password(String passWord) {
		super();
		this.passWord = passWord;
	}

	public String getPassWord() {
		return passWord;
	}

	public static boolean isValidPassWord(String password) {
		return Format.formatPassword(password);
	}
}
