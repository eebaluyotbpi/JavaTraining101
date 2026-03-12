package com.bpi.training.Module9Exe4;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DashboardController {


	@GetMapping("/home")
	public String home() {
			return "Welcome to home portal";
	}
	@PreAuthorize(("#username == authentication.name"))
	@GetMapping("/profile/admin/{admin}")
	public String getAdminByUsername(@PathVariable String admin) {
			return "Welcome to admin" + admin;
	}
	@GetMapping("/reports")
		public String reports(){
			return "Welcome to Manager Reports Portal";
	}

	@GetMapping("/dashboard")
		public String dashboard(){
			return "Welcome to User Dashboard";
	}

	@GetMapping("/profile")
	public String profile() {
			return "Welcome to profile";

	}
	@PreAuthorize(("#username == authentication.name"))
	@GetMapping("/profile/username/{username}")
		public String getProfileByUsername(@PathVariable String username){
			return "Welcome, " + username;

	}



}
