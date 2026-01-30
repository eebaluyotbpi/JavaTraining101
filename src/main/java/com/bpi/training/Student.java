package com.bpi.training;

import com.bpi.training.Courses;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name ="id", columnDefinition = "int")
		private int id;

		@Column(name = "age", columnDefinition = "int")
		private int age;

		@Column(name = "email",
						columnDefinition = "VARCHAR(50)",
						length = 50, nullable = false,
						unique = true)
		private String email;

		@Column(name = "name", columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
		private String name;

		@OneToMany(mappedBy = "student")
		private List<Courses> course;

		public int getId() {
				return id;
		}

		public void setId(int id) {
				this.id = id;
		}

		public int getAge() {
				return age;
		}

		public void setAge(int age) {
				this.age = age;
		}

		public String getEmail() {
				return email;
		}

		public void setEmail(String email) {
				this.email = email;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}



//		public List<Courses> getCourse() {
//				return course;
//		}
//
//		public void setCourse(List<Courses> course) {
//				this.course = course;
//		}
}
