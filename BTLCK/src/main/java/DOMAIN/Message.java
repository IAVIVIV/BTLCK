package DOMAIN;

public class Message {
	private ID id;
	private String sender;
	private String receiver;
	private String content;

	public Message(ID id, String sender, String receiver, String content) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
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
}
