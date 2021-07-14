package com.pack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pack.document.Customer;
@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
