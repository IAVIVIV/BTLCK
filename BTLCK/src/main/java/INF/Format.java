package INF;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Format {
	private static final int MAX_LENGTH_ID = 8;
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{1,10}$).*$";
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

	public static String formatID(String header, int number) {
		number++;
		int lengthHeader = header.length();
		int maxLengthFooterID = MAX_LENGTH_ID - lengthHeader;
		String id = header + String.format("%0" + maxLengthFooterID + "d", number);
		return id;
	}

	public static boolean formatEmail(String email) {
		if (email == null) {
			return false;
		}
		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}

	public static boolean formatPassword(String password) {
		if (password == null) {
			return false;
		}
		Matcher matcher = PASSWORD_PATTERN.matcher(password);
		return matcher.matches();
	}
}
