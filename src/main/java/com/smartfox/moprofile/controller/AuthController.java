package com.smartfox.moprofile.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfox.moprofile.config.JWTUtils;
import com.smartfox.moprofile.config.MoProfileUser;
import com.smartfox.moprofile.dto.AuthenticatedUserDTO;
import com.smartfox.moprofile.dto.LoginDTO;
import com.smartfox.moprofile.dto.RegisterRequestDTO;
import com.smartfox.moprofile.model.Role;
import com.smartfox.moprofile.model.RoleEnum;
import com.smartfox.moprofile.model.User;
import com.smartfox.moprofile.repository.RoleRepository;
import com.smartfox.moprofile.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

	private JWTUtils jwtUtils;
	private PasswordEncoder passwordEncoder;
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private AuthenticationManager authenticationManager;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
			RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTUtils jwtUtils) {

		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtils = jwtUtils;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO login){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJWTToken(authentication);
		
		MoProfileUser userDetails = (MoProfileUser) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item-> item.getAuthority()).collect(Collectors.toList());
		return ResponseEntity.ok(new AuthenticatedUserDTO(jwt, userDetails.getUsername(), userDetails.getEmail(), roles));
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO){
		if (userRepository.existsByUsername(registerRequestDTO.getUsername()) || userRepository.existsByEmail(registerRequestDTO.getEmail())) {
			Map<String, String> resp = new HashMap<String, String>();
			resp.put("username or email", "invalid");
			return ResponseEntity.badRequest().body(resp);
		}
		
		User user = new User(registerRequestDTO.getUsername(),  passwordEncoder.encode(registerRequestDTO.getPassword()), registerRequestDTO.getEmail());
		Set<String> strRoles =  new HashSet<String>(registerRequestDTO.getRoles());
		Set<Role> roles = new HashSet<>();
		
		Role role = roleRepository.findByName(RoleEnum.ROLE_USER).get();
		roles.add(role);
		
		
		user.setRoles(roles);
		userRepository.save(user);
		
		Map<String, String> resp = new HashMap<String, String>();
		resp.put("user", "registered");
		return ResponseEntity.ok(resp);
		
	}

}
