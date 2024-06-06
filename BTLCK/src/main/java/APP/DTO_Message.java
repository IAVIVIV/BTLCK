package APP;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DTO_Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private String content;
	private String sourceIP;
	private String destinationIP;
	private List<String> l = new ArrayList<String>();

	public DTO_Message(String content, String sourceIP, String destinationIP) {
		super();
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

	public List<String> getL() {
		return l;
	}

	public void setL(List<String> l) {
		this.l = l;
	}
}
