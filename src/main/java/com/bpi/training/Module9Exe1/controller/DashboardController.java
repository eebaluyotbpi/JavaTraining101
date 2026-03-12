package com.bpi.training.Module9Exe1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DashboardController {

		@GetMapping("/public/dashboard")
		public String dashboard(){
				return "Welcome to Dashboard Public";
		}

		@GetMapping("/secured/dashboard")
		public String secured(){
				return "Welcome to Dashboard Secured";
		}

		@GetMapping("/dashboard")
		public String dashboardTest(){
				return "Welcome to Dashboard";
		}

}
