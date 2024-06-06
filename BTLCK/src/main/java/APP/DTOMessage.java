package APP;

import DOMAIN.ID;

public class DTOMessage {
	private ID id;
	private String sender;
	private String receiver;
	private String content;
	private String key;

	public DTOMessage(ID id, String sender, String receiver, String content, String key) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
		this.key = key;
	}

	public ID getId() {
		return id;
	}

	public String getSender() {
		return sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getContent() {
		return content;
	}

	public String getKey() {
		return key;
	}
}
