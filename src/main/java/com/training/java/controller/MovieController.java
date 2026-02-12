package com.training.java.controller;

import com.training.java.ResponseStatus;
import com.training.java.model.Movie;
import com.training.java.service.MovieService;
import com.training.java.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class MovieController {

		private ResponseStatus status;
		private final MovieService movieService;

		public MovieController(MovieService movieService) {
				this.movieService = movieService;
		}

		public void registerRoutes() {



			// Get All movies
			get("/movies",(req,res) -> {
					Map<String, Object> response = new HashMap<>();
					response.put("status", ResponseStatus.SUCCESS);
					response.put("data", this.movieService.getAllMovies());
					return JsonUtil.toJson(response);
			});

			// Add Movie
			post("/movies", (req, res) -> {
						Map<String, Object> response = new HashMap<>();
						Movie movie = JsonUtil.fromJson(req.body(), Movie.class);
						res.type("applcation/json");
						response.put("status",ResponseStatus.SUCCESS);
						response.put("data", this.movieService.addMovie(movie));

						return JsonUtil.toJson(response);
				}); // check connection route

			// Get using ID
			get("/movies/:id", (req,res)-> {
				Long id = Long.valueOf(req.params("id"));
				Movie movie = movieService.findById(id);

				if(movie == null) {
						res.status(404);
						return JsonUtil.toJson(Map.of(
										"status", "error",
										"message", "Movie not found"
						));
				}
				res.status(200);
				return JsonUtil.toJson(Map.of(
								"status","Success",
								"message", "Movie found",
								"data",movie));
			});
		}
}
