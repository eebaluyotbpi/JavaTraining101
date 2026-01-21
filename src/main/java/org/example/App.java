package org.example;
import java.sql.*;
import java.util.Scanner;
//Add a student
// capture student details : name, age, email
// Store these details in a student table

// Add a course
// Assign a course to a specific student
// capture course name and grade
// store these details in a courses table
// ensure that each course is linked to a valid student
// display all students
// display all courses
//				CREATE ROLE postgres WITH LOGIN PASSWORD 'postgres';
//				GRANT ALL PRIVILEGES ON DATABASE training_db TO postgres;
public class App {
		private final DbConnection conn = new DbConnection();
		private static final Scanner sc = new Scanner(System.in);
		private static final String INSERT_STUDENT = "INSERT INTO students (age,name,email) VALUES (?, ?, ?) RETURNING id";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		public static void main(String[] args) throws SQLException {
				Scanner sc = new Scanner(System.in);

				while (true) {
						System.out.println("\n=== MENU ===");
						System.out.println("1. Add Student");
						System.out.println("2. Add Course");
						System.out.println("3. Display All Students");
						System.out.println("4. Display All Courses");
						System.out.println("5. Exit");
						System.out.print("Choose: ");

						int choice = sc.nextInt();
						sc.nextLine(); // consume newline

						switch (choice) {
								case 1 -> {
										System.out.print("Name: ");
										String name = sc.nextLine();

										System.out.print("Age: ");
										int age = sc.nextInt();
										sc.nextLine();

										System.out.print("Email: ");
										String email = sc.nextLine();

										addStudent(name, age, email);
								}

								case 2 -> {
										System.out.print("Course Name: ");
										String cname = sc.nextLine();

										System.out.print("Grade: ");
										String grade = sc.nextLine();

										System.out.print("Student ID: ");
										int sid = sc.nextInt();
										sc.nextLine();

										addCourse(cname, grade, sid);
								}

								case 3 -> displayStudents();
								case 4 -> displayCourses();
								case 5 -> {
										System.out.println("Goodbye!");
										return;
								}

								default -> System.out.println("Invalid choice.");
						}
				}


		} // end of main
		public static void addStudent(String name, int age, String email) throws SQLException {

//				if(checkDuplicate(conn,name)) {
//						System.out.println("Name :" + name + " already exists. Cannot Insert");
//						return;
//				}

				

				try(Connection conn = DbConnection.getConnection();
						PreparedStatement psmt = conn.prepareStatement(INSERT_STUDENT)) {
						psmt.setInt(1, age);
						psmt.setString(2, name);
						psmt.setString(3, email);

						try (ResultSet rs = psmt.executeQuery()) {
								if (rs.next()) {
										int newId = rs.getInt("id");
										System.out.println("Inserted student_id = " + newId);
								} else {
										throw new SQLException("Insert succeeded but no id returned.");
								}
						}

				}
		} // end of add student

		public static void addCourse(String courseName, String grade, int studentId) throws SQLException{

				String sql = "INSERT INTO courses (course_name, grade, student_id) VALUES (?, ?, ?)";

				try (Connection conn = DbConnection.getConnection();
							PreparedStatement ps = conn.prepareStatement(sql)) {

						ps.setString(1, courseName);
						ps.setString(2, grade);
						ps.setInt(3, studentId);
						int rows = ps.executeUpdate();

						System.out.println(rows > 0 ? "Course Added Successfully!" : "Failed to Add Course.");
				}

		}// end of add course

		public static void displayCourses() throws SQLException {
						String sql = """
            SELECT c.id, c.course_name, c.grade, s.name AS student_name
            FROM courses c
            JOIN students s ON c.student_id = s.id
            ORDER BY c.id
        """;

						try(Connection conn = DbConnection.getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
								ResultSet rs = ps.executeQuery()){

										System.out.println("\n=== COURSE LIST ===");
										boolean found = false;

										while (rs.next()) {
												found = true;
												System.out.printf(
																"%d | %s | %s | Student: %s%n",
																rs.getInt("id"),
																rs.getString("course_name"),
																rs.getString("grade"),
																rs.getString("student_name")
												);
										}
										if (!found) {
												System.out.println("No courses available.");
										}
								}
						} // end of display course


		public static void displayStudents() throws SQLException {
				String sql = "SELECT * FROM students ORDER BY id";

				try (Connection conn = DbConnection.getConnection();
						 PreparedStatement ps = conn.prepareStatement(sql);
						 ResultSet rs = ps.executeQuery()) {

						System.out.println("\n=== STUDENT LIST ===");
						boolean found = false;

						while (rs.next()) {
								found = true;
								System.out.printf("%d | %s | %d | %s%n",
												rs.getInt("id"),
												rs.getString("name"),
												rs.getInt("age"),
												rs.getString("email"));
						}

						if (!found) {
								System.out.println("No data available.");
						}
				}
		}


}




