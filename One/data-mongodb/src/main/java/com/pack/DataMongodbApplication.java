package com.pack;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pack.document.Customer;
import com.pack.repository.CustomerRepository;

@SpringBootApplication
public class DataMongodbApplication  implements  CommandLineRunner {
	
	@Autowired
	ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(DataMongodbApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		  CustomerRepository  custRepo=(CustomerRepository)ctx.getBean("customerRepository");
	/*	  Customer  customer=new Customer();
		  customer.setCustomerId(12011);
		  customer.setCustomerName("KOUSHIK");
		  customer.setCity("HYDERABAD");
		  
		  custRepo.save(customer);  */
		  
		  Optional<Customer>    opt = custRepo.findById(12011);
		  Customer  customer=opt.get();
		  System.out.println(customer.getCustomerName());
		  System.out.println(customer.getCity());
		
		
	}

}
