package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

		public static Connection getConnection() {
				try {
						return DriverManager.getConnection(
										"jdbc:postgresql://localhost:5432/training_db",
										"eebaluyot",
										""
						);
				} catch (Exception e) {
						e.printStackTrace();
						return null;
				}
		}
}
