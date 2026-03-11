package com.bpi.training.Module9Exe1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DashboardController {

		@GetMapping("/dashboard")
		public String dashboard(){
				return "Welcome to Dashboard";
		}
}
