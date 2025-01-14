package net.sta.mysql;

import lombok.Getter;
import net.sta.Debugging;

import java.sql.*;

public class MySql implements Debugging {
	@Getter public Connection con;
	@Getter private final String host;
	@Getter private final String port;
	@Getter private final String database;
	@Getter private final String username;
	@Getter private final String password;

	public MySql(String host, String port, String database, String username, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;
		mysqlConnection();
	}

	private void mysqlConnection() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:net.sta.mysql://" + host + ":" + port + "/" + database, username, password);
				debug().info("Mysql connection established.");
			} catch (SQLException e) {
				debug().info("Mysql connection failed: " + e.getMessage());
			}
		} else {
			debug().info("Mysql connection is already established.");
		}
	}

	public boolean isConnected() {
		return (con != null);
	}

}
