package DOMAIN;

import java.util.List;

import APP.DTOMessage;
//import APP.DTOMessage;
import APP.DTOUser;

public interface Repository {
	public void addUser(DTOUser user);

	public String findUser(String email);

	public void addMessage(DTOMessage message);

	public String findMaxId(String type);

	public DTOUser userExists(String username);

	public List<DTOMessage> messageExists(String sender, String receiver);
}
