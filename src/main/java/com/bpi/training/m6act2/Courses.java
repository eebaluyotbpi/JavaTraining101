package com.bpi.training.m6act2;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", columnDefinition = "Bigint")
		private Long id;

		@Column(name ="grade", columnDefinition = "Double(5,2)", nullable = false)
		private double grade;

		@Column(name = "course_name", columnDefinition = "VARCHAR(100)", nullable = false,length = 50)
		private String course_name;

		@Column(name = "student_id", columnDefinition = "Bigint",nullable = false)
		private int student_id;



		@ManyToOne
		@JoinColumn(name = "student_id", insertable = false, updatable = false)
		private Student student;

		public Student getStudent() {
				return student;
		}

		public void setStudent(Student student) {
				this.student = student;
		}

		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public double getGrade() {
				return grade;
		}

		public void setGrade(double grade) {
				this.grade = grade;
		}

		public String getCourse_name() {
				return course_name;
		}

		public void setCourse_name(String course_name) {
				this.course_name = course_name;
		}

		public int getStudent_id() {
				return student_id;
		}

		public void setStudent_id(int student_id) {
				this.student_id = student_id;
		}



}
