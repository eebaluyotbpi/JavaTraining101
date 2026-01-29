package com.bpi.training.m6Act4;

import jakarta.persistence.*;

@Entity
@Table(name ="profiles")
public class Profile {

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;


		@Column(name = "address", nullable = false, length = 500, columnDefinition = "VARCHAR(500)")
		private String address;

		@Column(name = "nationality", columnDefinition = "VARCHAR(50)", length = 50)
		private String nationality;

		@OneToOne
		@JoinColumn(name = "student_id")
		private Student students;


		public Student getStudent() {
				return students;
		}

		public void setStudent(Student student) {
				this.students = student;
		}

		public int getId() {
				return id;
		}

		public void setId(int id) {
				this.id = id;
		}

		public String getAddress() {
				return address;
		}

		public void setAddress(String address) {
				this.address = address;
		}

		public String getNationality() {
				return nationality;
		}

		public void setNationality(String nationality) {
				this.nationality = nationality;
		}
}
