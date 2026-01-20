package org.example;

import java.sql.*;

public class Main {
		private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
		private static final String USER = "eebaluyot";
		private static final String PASSWORD = "";
		public static void main(String[] args) {
//				CREATE ROLE postgres WITH LOGIN PASSWORD 'postgres';
//				GRANT ALL PRIVILEGES ON DATABASE training_db TO postgres;
				Connection connection = null;
				Statement statement = null;
				ResultSet resultSet = null;

				try {
						connection = DriverManager.getConnection(URL,USER,PASSWORD);
						System.out.println("Connected to PostGreSQL successfully!");

						// create statement
						statement = connection.createStatement();

						// Execute Query
						String sql = "SELECT id,name,email FROM students";

						resultSet = statement.executeQuery(sql);


						while(resultSet.next()) {
								int id = resultSet.getInt("id");
								String name = resultSet.getString("name");
								String email = resultSet.getString("email");

								System.out.println(id + " | " + name + " | " + email);
						}
				} catch (Exception e) {
						e.printStackTrace();
				} finally {
						try {
								resultSet.close();
						} catch (SQLException e) {
								e.printStackTrace();
						}
				}

		}
} // end of main
