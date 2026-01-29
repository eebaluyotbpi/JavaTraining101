package com.bpi.training.m6Act4;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="clubs")
public class Club {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long Id;

		@Column(name = "name", columnDefinition = "VARCHAR(50)",
						length = 50,
						nullable = false)
		private String name;

		@Column(name = "description",
						columnDefinition = "VARCHAR(50)",
						nullable = false,
						unique = true,
						length = 50)
		private String description;



		@ManyToMany
		@JoinTable(name = "students_club"
						, joinColumns = @JoinColumn(name = "club_id")
						, inverseJoinColumns = @JoinColumn(name = "student_id"))
		private List<Student> students;

		public List<Student> getStudents() {
				return students;
		}

		public void setStudents(List<Student> students) {
				this.students = students;
		}

		public Long getId() {
				return Id;
		}

		public void setId(Long id) {
				Id = id;
		}

		public String getName() {
				return name;
		}

		public void setName(String name) {
				this.name = name;
		}

		public String getDescription() {
				return description;
		}

		public void setDescription(String description) {
				this.description = description;
		}
}
