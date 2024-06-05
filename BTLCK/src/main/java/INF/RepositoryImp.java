package INF;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import APP.DTOMessage;
import APP.DTOUser;
import DOMAIN.Email;
import DOMAIN.Factory;
import DOMAIN.ID;
import DOMAIN.Password;
import DOMAIN.Repository;

public class RepositoryImp implements Repository {
	private static final String INSERT_USER_SQL = "INSERT INTO user (id, username, email, password, `key`) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_USERNAME_SQL = "SELECT username FROM user WHERE email = ?";
	private static final String INSERT_MESSAGE_SQL = "INSERT INTO message (id, sender, receiver, content, `key`) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_USER_SQL = "SELECT * FROM user WHERE username = ?";
	private static final String SELECT_MESSAGE_SQL = "SELECT * FROM message WHERE sender = ? AND receiver = ? UNION ALL SELECT * FROM message WHERE sender = ? AND receiver = ?";

	@Override
	public void addUser(DTOUser user) {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
			preparedStatement.setString(1, user.getId().getId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getEmail().getEmail());
			preparedStatement.setString(4, user.getPassword().getPassWord());
			preparedStatement.setString(5, user.getKey());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String findUser(String email) {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERNAME_SQL)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void addMessage(DTOMessage message) {
//		try (Connection connection = DatabaseConnection.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MESSAGE_SQL)) {
//			preparedStatement.setString(1, message.getId().getId());
//			preparedStatement.setString(2, message.getSender());
//			preparedStatement.setString(3, message.getReceiver());
//			preparedStatement.setString(4, message.getContent());
//			preparedStatement.setString(5, message.getKey());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public String findMaxId(String type) {
		String SELECT_MAX_ID_SQL = "SELECT id FROM " + type
				+ " ORDER BY CAST(SUBSTRING(id, 5) AS UNSIGNED) DESC LIMIT 1";
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAX_ID_SQL)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DTOUser userExists(String username) {
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL)) {
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Factory f = new Factory();
				ID id = f.create_ID(resultSet.getString("id"));
				String userName = resultSet.getString("username");
				Email email = f.createEmail(resultSet.getString("email"));
				Password password = f.createPassword(resultSet.getString("password"));
				String key = resultSet.getString("key");
				return new DTOUser(id, userName, email, password, key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public List<DTOMessage> messageExists(String sender, String receiver) {
//		try (Connection connection = DatabaseConnection.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MESSAGE_SQL)) {
//			preparedStatement.setString(1, sender);
//			preparedStatement.setString(2, receiver);
//			preparedStatement.setString(3, receiver);
//			preparedStatement.setString(4, sender);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			List<DTOMessage> list = new ArrayList<DTOMessage>();
//			while (resultSet.next()) {
//				Factory f = new Factory();
//				ID id = f.create_ID(resultSet.getString("id"));
//				String sender_o = resultSet.getString("sender");
//				String receiver_o = resultSet.getString("receiver");
//				String content = resultSet.getString("content");
//				String key = resultSet.getString("key");
//				DTOMessage message = new DTOMessage(id, sender_o, receiver_o, content, key);
//				list.add(message);
//			}
//			Collections.sort(list, new Comparator<DTOMessage>() {
//				@Override
//				public int compare(DTOMessage message1, DTOMessage message2) {
//					return message1.getId().getId().compareTo(message2.getId().getId());
//				}
//			});
//
//			return list;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
