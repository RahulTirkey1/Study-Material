package com.ems.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
	@Autowired
	JdbcTemplate    jdbcTemplate;
	
	

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder  encoder=new  BCryptPasswordEncoder();
		/*
		String  pwd1 = encoder.encode("tech123");
		String  pwd2= encoder.encode("sun@123");
		
		jdbcTemplate.update("insert  into  users  values(?,?,?)",  "sathya",  pwd1, 0);
		jdbcTemplate.update("insert  into  users  values(?,?,?)",  "allen",  pwd2, 1 );
		
		jdbcTemplate.update("insert  into  authorities  values(?, ?) ", "sathya", "ROLE_ADMIN");
		jdbcTemplate.update("insert  into  authorities  values(?, ?) ", "allen", "ROLE_ACCOUNTANT");
       */
		
		/*
		String  pwd3 = encoder.encode("boot#111");
		jdbcTemplate.update("insert  into  users  values(?,?,?)",  "clark",  pwd3, 1);
		jdbcTemplate.update("insert  into  authorities  values(?, ?) ", "clark", "ROLE_ACCOUNTANT");
		*/
		
	}

}
