package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
