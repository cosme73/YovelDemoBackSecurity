package com.example.api_examen_final_20211c49220231.Controllers;

import com.example.api_examen_final_20211c49220231.ServicesImplements.JwtUserDetailsService;
import com.example.api_examen_final_20211c49220231.security.JwtRequest;
import com.example.api_examen_final_20211c49220231.security.JwtResponse;
import com.example.api_examen_final_20211c49220231.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//Clase 3
@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager ycqtAuthenticationManager;
	@Autowired
	private JwtTokenUtil ycqtJwtTokenUtil;
	@Autowired
	private JwtUserDetailsService ycqtUserDetailsService;
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getYcqtusername(), authenticationRequest.getYcqtpassword());
		final UserDetails ycqtuserDetails = ycqtUserDetailsService.loadUserByUsername(authenticationRequest.getYcqtusername());
		final String ycqtToken = ycqtJwtTokenUtil.ycqtGenerateToken(ycqtuserDetails);
		return ResponseEntity.ok(new JwtResponse(ycqtToken));
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			ycqtAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}