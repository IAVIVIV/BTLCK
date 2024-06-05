package DOMAIN;

import INF.Format;

public class ID {
	private String id;

	public ID(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static ID randomID(String idHeader, int number) {
		String idStr = Format.formatID(idHeader, number);
		ID id = new ID(idStr);
		return id;
	}

	public static int cutNumber(String id) {
		String numberPart = id.substring(4);
		return Integer.parseInt(numberPart);
	}
}
