package com.smartfox.moprofile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.smartfox.moprofile.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsServiceImpl userDetailsServiceImpl;
	private JWTUtils jwtUtils;
	
	public WebSecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, JWTUtils jwtUtils) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
		this.jwtUtils = jwtUtils;
	}
	
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}
	
	
	@Bean
	public AuthTokenFilter authTokenFilter() {
		return new AuthTokenFilter(jwtUtils, userDetailsServiceImpl);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	public void configure(HttpSecurity http)throws Exception {
		http
			.cors().and().csrf().disable()
			.authorizeRequests()
			  .antMatchers("/api/auth/**").permitAll()
			  .anyRequest().authenticated();
		http.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
