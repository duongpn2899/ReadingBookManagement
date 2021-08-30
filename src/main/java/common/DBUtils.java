package common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	private static DBUtils instance;
	private Connection connection;
	
	private DBUtils() {
		Properties properties = new Properties();
		try {
			properties.load(DBUtils.class.getResourceAsStream("/dbConfig.properties"));
			String url = properties.getProperty("url");
			String userName = properties.getProperty("userName");
			String password = properties.getProperty("password");
			
			connection = DriverManager.getConnection(url, userName, password);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return connection;
	}
	
	public static DBUtils getInstance() throws SQLException {
		if (instance == null || instance.getConnection().isClosed()) {
			instance = new DBUtils();
		}
		return instance;
	}

	
}