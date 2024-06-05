package BS;

import INF.Server;

public class Main {
	public static void main(String[] args) {
		int port = 12345;
		Server server = new Server(port);
		server.startServer();
	}
}
