package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.entity.Donor;

@Repository
public interface DonorRepository extends JpaRepository<Donor, String> {

}
