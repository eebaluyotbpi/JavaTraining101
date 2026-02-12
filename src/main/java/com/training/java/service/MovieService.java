package com.training.java.service;

import com.training.java.dto.MovieDto;
import com.training.java.model.Movie;
import com.training.java.repository.MovieRepository;
import com.training.java.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class MovieService {
		private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
		// holder of the movies that we created
		private EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
		private MovieRepository movieRepository;

		public MovieService () {
				this.movieRepository =  new MovieRepository(em);
		}

	private final List<Movie> movieList = new ArrayList<>();

	public List<MovieDto> listMovie(){
			movieRepository.findAll();
			return movieList
							.stream()
							.map(x -> new MovieDto(x))
							.collect(Collectors.toList());
	}

	public List<Movie> getAllMovies(){

			return this.movieRepository.findAll();
	}


	// Create a movie
	public Movie addMovie(Movie movie) {
			try {
					return movieRepository.save(movie);
			} catch (Exception e) {
					logger.error("Error saving movie", e);
					throw e;
			}
		} // end of addmovie

	public Movie findById(Long id) {

			try {
					Movie movie =movieRepository.findById(id);
					if(movie == null) {
							logger.warn("Movie not found with id= {}", movie);

					}
					return movie;
			} catch (Exception e) {
					logger.error("Error fetching movie by id = {}", id,e);
					throw e;
			}
	}



}
