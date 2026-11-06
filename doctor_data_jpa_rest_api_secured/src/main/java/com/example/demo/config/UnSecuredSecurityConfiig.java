package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@Profile("dev")
public class UnSecuredSecurityConfiig {

	
	
	@Bean
	BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	UserDetailsService  registerUsers(BCryptPasswordEncoder encoder) {
		
		UserDetails adminUser =User.builder()
				   .username("india")
				      .password(encoder.encode("india"))
				      .roles("ADMIN")
				      .build();

		UserDetails guestUser =User.builder()
				   .username("nepal")
				      .password(encoder.encode("nepal"))
				      .roles("GUEST")
				      .build();

		return new InMemoryUserDetailsManager(adminUser,guestUser);
	}
	@Bean
	SecurityFilterChain config(HttpSecurity http) throws Throwable{
		
		
		 http.csrf(csrf -> csrf.disable())
		 .authorizeHttpRequests(auth -> 
		         auth.anyRequest().permitAll());
		         
		
		return http.httpBasic(Customizer.withDefaults()).build();

		
	}
}


