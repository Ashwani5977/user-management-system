package com.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static HikariDataSource dataSource;
	static {
	    try {
	        String url = System.getenv("JDBC_URL");
	        String username = System.getenv("DB_USER");
	        String password = System.getenv("DB_PASSWORD");
	        HikariConfig config = new HikariConfig();
	        config.setJdbcUrl(url);
	        config.setUsername(username);
	        config.setPassword(password);
	        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource = new HikariDataSource(config);
	        System.out.println("DB Connected Successfully");
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	public static void close(AutoCloseable resource) {
		if(resource!=null) {
			try {
				resource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
