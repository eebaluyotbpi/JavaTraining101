package com.training.java.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(nullable = false, length = 100, name = "title")
		private String title;

		@Column(nullable = false, length = 100, name = "director")
		private String director;
		@Column(nullable = false, length = 10, name = "showing_date")
		private String showingDate;



		public Long getId() {
				return id;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public String getTitle() {
				return title;
		}

		public void setTitle(String title) {
				this.title = title;
		}

		public String getDirector() {
				return director;
		}

		public void setDirector(String director) {
				this.director = director;
		}

		public String getShowingDate() {
				return showingDate;
		}

		public void setShowingDate(String showingDate) {
				this.showingDate = showingDate;
		}
}
