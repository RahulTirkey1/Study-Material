package com.pack;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pack.entity.Passport;
import com.pack.entity.Person;
import com.pack.repository.PassportRepository;

@SpringBootApplication
public class DatajpaOnetoonefkApplication  implements  CommandLineRunner {
	@Autowired
	ApplicationContext  ctx;

	public static void main(String[] args) {
		SpringApplication.run(DatajpaOnetoonefkApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		PassportRepository   passRepo=(PassportRepository)ctx.getBean("passportRepository");
		
		Person  person=new  Person();
		person.setPersonId(10101);
		person.setPersonName("Koushik");
		
		Passport  passport=new  Passport();
		//passport.setPassportId(9911202);
		
		try {
			SimpleDateFormat  sdf=new  SimpleDateFormat("dd-MM-yyyy");
			java.util.Date   expDate=sdf.parse("31-12-2025");
			passport.setExpireDate(expDate);
		}catch(Exception  e) { }
		
		passport.setPerson(person);
		
		passRepo.save(passport);
		
	}

}
