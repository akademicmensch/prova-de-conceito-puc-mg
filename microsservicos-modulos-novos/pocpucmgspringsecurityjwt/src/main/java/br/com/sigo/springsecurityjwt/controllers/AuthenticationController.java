package br.com.sigo.springsecurityjwt.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigo.springsecurityjwt.models.AuthenticationRequest;
import br.com.sigo.springsecurityjwt.models.AuthenticationResponse;
import br.com.sigo.springsecurityjwt.models.SampleUser;
import br.com.sigo.springsecurityjwt.services.MyUserDetailsService;
import br.com.sigo.springsecurityjwt.util.JwtUtil;
import io.jsonwebtoken.Jwts;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch (BadCredentialsException e) {
			throw new Exception("Usuario ou senha invalidos! : ", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@PostMapping(value="/details")
	public SampleUser getUserDetailsByJwt(HttpServletRequest rq) {
		String auth = rq.getHeader("Authorization");
		auth = auth.replace("Bearer ", "");
		
		String name = Jwts.parser().setSigningKey("secret").parseClaimsJws(auth).getBody().get("sub", String.class);
		
		return userDetailsService.retornarUsuarioERole(name);
	}
}
