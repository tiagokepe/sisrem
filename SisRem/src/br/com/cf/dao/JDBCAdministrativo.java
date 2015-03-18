package br.com.cf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCAdministrativo {
	private static Connection connection = null;

	public static void connect() {
		try {
			if (connection == null) {
				String host = "200.17.98.75";
				String database = "administrativo";
				String username = "postgres";
				String password = "";
				String url = "jdbc:postgresql://" + host + "/" + database;
				String driverJDBC = "org.postgresql.Driver";
				Class.forName(driverJDBC);
				connection = DriverManager.getConnection(url, username,
						password); // line firing the class not found exception

				//connection.close();

			} else if (connection.isClosed()) {
				connection = null;
				connect();
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public static void disconnect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println();
			}
		}
	}

	public static Connection getConnection() {

		try {
			if (connection != null && !connection.isClosed()) {
				return connection;
			} else {
				connect();
				return connection;
			}
		} catch (SQLException e) {
			System.err.println();
			return null;
		}
	}

	@Override
	public void finalize() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println();
			}
		}
	}

}