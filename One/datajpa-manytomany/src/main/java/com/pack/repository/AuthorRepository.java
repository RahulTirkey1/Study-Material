package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
