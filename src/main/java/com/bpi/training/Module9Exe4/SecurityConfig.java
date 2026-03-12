package com.bpi.training.Module9Exe4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

		// Exercise 1

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				http
								.authorizeHttpRequests(auth -> auth
												.requestMatchers("/dashboard").hasAnyRole("USER","ADMIN")
												.requestMatchers("/reports").hasRole("ADMIN")
												.requestMatchers("/home").hasAnyRole("USER","ADMIN")
												.requestMatchers("/profile/admin/**").hasRole("ADMIN")

												.anyRequest().authenticated())
								.httpBasic(withDefaults());


				return http.build();
		}
		// Exercise 2
		@Bean
		public UserDetailsManager userDetailsManager() {
				UserDetails dev_1 = User.withUsername("dev_1")
								.password(passwordEncoder().encode("password"))
								.roles("USER")
								.build();
				UserDetails dev_2 = User.withUsername("dev_2")
								.password(passwordEncoder().encode("password"))
								.roles("USER")
								.build();
				UserDetails manager = User.withUsername("mgr_1")
								.password(passwordEncoder().encode("admin"))
								.roles("ADMIN")
								.build();

				return  new InMemoryUserDetailsManager(dev_1,dev_2,manager);
		}
		// Exercise 3
		@Bean
		public BCryptPasswordEncoder passwordEncoder(){
				return new BCryptPasswordEncoder();
		}
}
