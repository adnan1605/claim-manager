package com.cts.authorization.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cts.authorization.filter.JwtUtil;
import com.cts.authorization.model.Role;
import com.cts.authorization.model.User;
//import com.cts.authorization.service.JwtUserDetailsService;
//import com.cts.authorization.service.JwtUserDetailsService;
import com.cts.authorization.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationController {
	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	private final UserDetailsService userDetailsService;
	private final JwtUtil jwt;
	//private final JwtUserDetailsService userDetailsService;



@PostMapping("/signin")
public ResponseEntity<String>  authentication(@RequestBody User user){
        try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null));
			UserDetails user1 =
					userDetailsService.loadUserByUsername(user.getUsername());
			log.info(String.valueOf(user1));
			return ResponseEntity.status(200).body(jwt.generateToken(user1));
		}
		catch(BadCredentialsException ex){
			return ResponseEntity.status(401).body("unauthorized");
		}

}


	@GetMapping(value = "/getUser")
	ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}

	@PostMapping("/user/save")
	ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.saveUser(user));
	}

	@PostMapping("/role/save")
	ResponseEntity<Role> saveUser(@RequestBody Role role) {
		return ResponseEntity.ok().body(userService.saveRole(role));
	}

	@PostMapping("/role/addRoleToUser")
	ResponseEntity<?> addRoleToUser(@RequestBody RoleForm roleForm) {
		userService.addRoleToUser(roleForm.getUsername(), roleForm.getRole());
		return ResponseEntity.ok().build();
	}



	@GetMapping("/refresh/token")
	public void getRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		log.info(request.getHeader(AUTHORIZATION));
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refresh_token = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verfier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verfier.verify(refresh_token);
				String username = decodedJWT.getSubject();
				User user = userService.getUser(username);
				String access_token = JWT.create()
						.withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
						.sign(algorithm);
response.setHeader("access_token",access_token);
        response.setHeader("refresh_token",refresh_token);

				HashMap<String, String> token = new HashMap<>();
				token.put("access_token", access_token);
				token.put("refresh_token", refresh_token);
				response.setContentType(APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), token);

			} catch (Exception exception) {
				log.error("Error in :{}", exception.getMessage());
				response.setHeader("error", exception.getMessage());
				response.setStatus(FORBIDDEN.value());
				//response.sendError(FORBIDDEN.value());
				HashMap<String, String> error = new HashMap<>();
				response.setContentType(APPLICATION_JSON_VALUE);
				error.put("error_in_refresh_token_message", exception.getMessage());
				new ObjectMapper().writeValue(response.getOutputStream(), error);
			}
		} else {
			throw new RuntimeException("token is missing");

		}
	}

}
@Data
class RoleForm{
	String username;
	String role;
}
