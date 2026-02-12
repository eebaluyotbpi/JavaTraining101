package com.training.java.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconfig {
		private static final String _JDBC = "jdbc:postgresql://localhost:5432/library_db";
		private static final String _USER = "eebaluyot";
		private static final String _PASSWORD = "";

		private Dbconfig() {};

		public static Connection getConnection() {
				try {
						return DriverManager.getConnection(_JDBC,_USER,_PASSWORD);

				} catch (Exception e) {
						e.printStackTrace();
						return null;
				}
		}
}
