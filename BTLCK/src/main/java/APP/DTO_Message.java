package APP;

import java.io.Serializable;

public class DTO_Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String content;
	private String sourceIP;
	private String destinationIP;

	public DTO_Message(String content, String sourceIP, String destinationIP) {
		this.content = content;
		this.sourceIP = sourceIP;
		this.destinationIP = destinationIP;
	}

	public String getContent() {
		return content;
	}

	public String getSourceIP() {
		return sourceIP;
	}

	public String getDestinationIP() {
		return destinationIP;
	}
}
