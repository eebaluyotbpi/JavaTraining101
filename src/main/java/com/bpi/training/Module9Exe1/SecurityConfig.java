package com.bpi.training.Module9Exe1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

		// Exercise 1

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				http
								.authorizeHttpRequests(auth -> auth
												.requestMatchers("/public/**").permitAll()
												.requestMatchers("/secured/**").authenticated())
								.httpBasic(withDefaults());
				return http.build();
		}
		// Exercise 2
		@Bean
		public InMemoryUserDetailsManager userDetailsManager() {
				UserDetails user = User.withUsername("user")
								.password(passwordEncoder().encode("password"))
								.roles("USER")
								.build();
				System.out.println("encrypted password of user" + passwordEncoder().encode("admin"));
				UserDetails admin = User.withUsername("admin")
								.password(passwordEncoder().encode("admin"))
								.roles("ADMIN")
								.build();
				System.out.println("encrypted password of admin" + passwordEncoder().encode("admin"));
				return  new InMemoryUserDetailsManager(user,admin);
		}
		// Exercise 3
		@Bean
		public BCryptPasswordEncoder passwordEncoder(){
				return new BCryptPasswordEncoder();
		}
}
