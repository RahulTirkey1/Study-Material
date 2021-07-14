package com.pack.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.pack.entity.Passenger;
import com.pack.repository.PassengerRepository;

@Component
public class HomeCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	ApplicationContext  ctx;

	@Override
	public void run(String... args) throws Exception {
		
		  PassengerRepository  repo=(PassengerRepository)ctx.getBean("passengerRepository");
		/*
		 * Optional<Passenger> opt=repo.findById(13321); Passenger p = opt.get();
		 * System.out.println(p);
		 */
		  
		/*
		 * List<Passenger> passengerList=repo.findAll(); passengerList.forEach(p1 ->
		 * System.out.println(p1));
		 */
		  
		/*
		 * Passenger passenger=repo.findByEmailId("madhavi@outlook.com");
		 * System.out.println(passenger);
		 */
		  
		/*
		 * List<Passenger> passengerBetweenList =
		 * repo.readPassengersBetweenSeatNumbers(1, 15); passengerBetweenList.forEach(p2
		 * -> System.out.println(p2));
		 */
		 
		/*
		 * List<Passenger> passengerByFirstNameList = repo.byFirstName();
		 * passengerByFirstNameList.forEach(pf -> System.out.println(pf));
		 */	  
		 
		 List<Passenger> passengerBetweenList =
				  repo.readPassengersBetweenSeat(10, 17); 
		 passengerBetweenList.forEach(p2-> System.out.println(p2));

	}

}
