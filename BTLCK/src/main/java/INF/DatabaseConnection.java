package INF;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DatabaseConnection {
	private static final String CONFIG_FILE_PATH = "databaseConfig.xml";

	public static Connection getConnection() throws SQLException {
		try {
			File file = new File(CONFIG_FILE_PATH);
			FileInputStream fis = new FileInputStream(file);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(fis);

			Element root = doc.getDocumentElement();
			NodeList nodes = root.getChildNodes();

			String url = null;
			String user = null;
			String password = null;

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					switch (element.getTagName()) {
					case "url":
						url = element.getTextContent();
						break;
					case "user":
						user = element.getTextContent();
						break;
					case "password":
						password = element.getTextContent();
						break;
					}
				}
			}

			return DriverManager.getConnection(url, user, password);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			throw new SQLException("Error while reading database configuration");
		}
	}
}
