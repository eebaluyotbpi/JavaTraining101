package com.bpi.training.m6Act4;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="students")
public class Student {
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private int age;
		private String name;

		private String email;


		@OneToOne(mappedBy = "students")
		private Profile profile;
		@OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
		private List<Course> courses = new ArrayList<>();

		@ManyToMany(mappedBy = "students")
		private List<Club> clubs;

		public Student(){}

		public Student(String name) {
				this.name = name;
		}

		//setters and getters


		public Profile getProfile() {
				return profile;
		}

		public void setProfile(Profile profile) {
				this.profile = profile;
		}

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public int getAge() {
				return age;
		}
		public void setAge(int age) {
				this.age = age;
		}

		public String getName() {
				return name;
		}
		public void setName(String name) {
				this.name = name;
		}

		public String getEmail() {
				return email;
		}
		public void setEmail(String email) {
				this.email = email;
		}

		public List<Course> getCourses() {
				return courses;
		}

		public void setCourses(List<Course> courses) {
				this.courses = courses;
		}

		public void addCourse(Course course) {
				courses.add(course);
				course.setStudents(this);
		}
//id age name email
}
