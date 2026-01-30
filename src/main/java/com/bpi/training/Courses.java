package com.bpi.training;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", columnDefinition = "INT")
		private Long id;

		@Column(name ="grade", columnDefinition = "Double(5,2)", nullable = false)
		private double grade;

		@Column(name = "course_name", columnDefinition = "VARCHAR(100)", nullable = false,length = 50)
		private String course_name;



//		@ManyToOne
//		@JoinColumn(name = "student_id", insertable = false, updatable = false)
		@ManyToOne
		@JoinColumn(name = "student_id")
		private Student student;

//		public Student getStudent() {
//				return student;
//		}
//
//		public void setStudent(Student student) {
//				this.student = student;
//		}

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

		public Student getStudent() {
				return student;
		}

		public void setStudent(Student student) {
				this.student = student;
		}
}
