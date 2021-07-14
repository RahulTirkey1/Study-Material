package com.ems.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BCryptPasswordEncoder   encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/delete**").hasAnyRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	
	@Autowired
	public   void   configureGlobal(AuthenticationManagerBuilder  builder)  throws  Exception {
		builder.inMemoryAuthentication()
		.withUser("sathya").password(encoder.encode("123456")).roles("ADMIN")
		.and()
		.withUser("allen").password(encoder.encode("allen123")).roles("ACCOUNTANT");
		
		
		
	}
	
	@Bean
	public   BCryptPasswordEncoder    encoder() {
		return   new  BCryptPasswordEncoder();
	}

}
