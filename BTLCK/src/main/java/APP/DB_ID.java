package APP;

import DOMAIN.ID;

public class DB_ID extends ID {
	private String idOther;
	private int number;

	public DB_ID(String id, int number) {
		super(id);
		this.idOther = id;
		this.number = number;
	}

	public String getIdOther() {
		return idOther;
	}

	public int getNumber() {
		return number;
	}
}
