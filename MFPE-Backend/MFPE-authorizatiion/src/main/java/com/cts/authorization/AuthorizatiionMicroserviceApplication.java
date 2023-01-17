package com.cts.authorization;

import com.cts.authorization.model.Role;
import com.cts.authorization.model.User;
import com.cts.authorization.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class AuthorizatiionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizatiionMicroserviceApplication.class, args);
	}
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
//						.allowCredentials(true);
//			}
//		};
//	}
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("OPTIONS");
//		config.addAllowedMethod("GET");
//		config.addAllowedMethod("POST");
//		config.addAllowedMethod("PUT");
//		config.addAllowedMethod("DELETE");
//		source.registerCorsConfiguration("/**", config);
//		return new CorsFilter(source);
//	}
@Bean
PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_DEVELOPER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));


			userService.saveUser(new User(null, "adnan_1605", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "irfan", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,  "sumit", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,  "kshitiz", "1234", new ArrayList<>()));

			userService.addRoleToUser("adnan_1605","ROLE_ADMIN");
			userService.addRoleToUser("irfan","ROLE_USER");
			userService.addRoleToUser("sumit","ROLE_USER");
			userService.addRoleToUser("kshitiz","ROLE_USER");
			userService.addRoleToUser("adnan_1605","ROLE_USER");

		};

	}
}
