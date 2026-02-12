package com.training.java.dto;

import com.training.java.model.Movie;

public class MovieDto {

//		private Long id;
		private String title;
		private String director;
		private String showingDate; // "yyyy-MM-dd"

		public MovieDto(Movie movieEntity) {
//				this.setId(movieEntity.getId());
				this.setTitle(movieEntity.getTitle());
				this.setDirector(movieEntity.getDirector());
				this.setShowingDate(movieEntity.getShowingDate());
		}

		public Movie toEntity() {
				Movie movie = new Movie();
//				movie.setId(this.getId());
				movie.setTitle(this.getTitle());
				movie.setDirector(this.getDirector());
				movie.setShowingDate(this.getShowingDate());

			return movie;
		}

//		public Long getId() {
//				return id;
//		}
//
//		public void setId(Long id) {
//				this.id = id;
//		}

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
