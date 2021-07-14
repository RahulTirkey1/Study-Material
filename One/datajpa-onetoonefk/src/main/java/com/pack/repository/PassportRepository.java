package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Integer> {

}
