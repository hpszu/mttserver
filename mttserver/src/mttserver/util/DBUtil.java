package mttserver.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBUtil {
	public static Connection getMySQLConnection(String driverClassName,
			String serverHost, String serverPort, String dbName,
			String userName, String password) throws ClassNotFoundException,
			SQLException {
		if (driverClassName == null) {
			driverClassName = "com.sql.jdbc.Driver";
		}
		if (serverHost == null) {
			serverHost = "127.0.0.1";
		}
		if (serverPort == null) {
			serverPort = "3306";
		}

		String dbURL = "jdbc:mysql://" + serverHost + ":" + serverPort + "/"
				+ dbName + "?characterEncoding=utf8";
		return getConnection(driverClassName, dbURL, userName, password);
	}

	private static Connection getConnection(String driverClassName,
			String dbURL, String userName, String password)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = null;

		Class.forName(driverClassName);

		con = DriverManager.getConnection(dbURL, userName, password);

		return con;
	}

	public static void close(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
