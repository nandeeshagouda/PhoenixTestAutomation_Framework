package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.utils.ConfigManager;

public class DataBaseManager {
	
	private static final String DB_URL=ConfigManager.getProperty("DB_URL");
	private static final String DB_USERNAME=ConfigManager.getProperty("DB_USER_NAME");
	private static final String BD_PASSWORD=ConfigManager.getProperty("BD_PASSWORD");
	private volatile static Connection conn;//Any update that happens to this conn variable!\
	//all the thread will be aware of it
	
	
	private DataBaseManager()
	{
		
	}
	
	public static void createConnection() throws SQLException {

		if (conn == null) {//first check which all the parallel threads will enter 
			synchronized (DataBaseManager.class) {
				if (conn == null) {
					conn = DriverManager.getConnection(DB_URL, DB_USERNAME, BD_PASSWORD);
					System.out.println(conn);
				}
			}
		}
	}

}
