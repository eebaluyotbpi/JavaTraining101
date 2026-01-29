package com.bpi.training.m6Act4;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
		@Id
//		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;



//		@Column(name = "grades", columnDefinition = "double(5,2)", length = 4)
		private double grade;

//		@Column(name = "courses_name", columnDefinition = "VARCHAR(50)", length = 50)
		private String course_name;


		@ManyToOne
		@JoinColumn(name = "student_id")
		private Student students;

		public Course(){}
		public Student getStudents() {
				return students;
		}

		public Course(String course_name) {
				this.course_name = course_name;
		}

		public void setStudents(Student students) {
				this.students = students;
		}


		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getCourse_name() {
				return course_name;
		}

		public void setCourse_name(String course_name) {
				this.course_name = course_name;
		}

		public double getGrade() {
				return grade;
		}

		public void setGrade(double grade) {
				this.grade = grade;
		}

//		public int getStudent_id() {
//				return student_id;
//		}
//
//		public void setStudent_id(int student_id) {
//				this.student_id = student_id;
//		}
}
