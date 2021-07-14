package com.pack;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pack.entity.Customer;
import com.pack.repository.CustomerRepository;

@SpringBootApplication
public class DatajpaOnetomanyApplication  implements  CommandLineRunner {

	@Autowired
	ApplicationContext   ctx;
	 
	public static void main(String[] args) {
		SpringApplication.run(DatajpaOnetomanyApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		CustomerRepository
		  custRepo=(CustomerRepository)ctx.getBean("customerRepository");
		
		/*
		 * Customer customer=new Customer(101, "A", 9003002121L);
		 * 
		 * Order order1=new Order(91911, "TV", 5000.0); Order order2=new
		 * Order(91922,"LAPTOP", 25000.0); Order order3=new Order(91933, "BAG", 600.0);
		 * 
		 * Set<Order> orders=new HashSet<Order>(); orders.add(order1);
		 * orders.add(order2); orders.add(order3);
		 * 
		 * customer.setOrders(orders);
		 * 
		 * 
		 * custRepo.save(customer);
		 */
		 
		/*
		 * Optional<Customer> opt = custRepo.findById(101); Customer cust =opt.get();
		 */
		
		custRepo.deleteById(101);
		
		
		
		
		
		
			
	}

}
