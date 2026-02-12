package com.training.java.app;

import com.training.java.controller.MovieController;
import com.training.java.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.port;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
		private static final Logger logger = LoggerFactory.getLogger(Main.class);
		public static void main(String[] args) throws Exception {

				// default port
				port(4568);

				MovieService movieService = new MovieService();
				MovieController movieController = new MovieController(movieService);
				movieController.registerRoutes();
				logger.info("Server started at port {}", port());

		}
}