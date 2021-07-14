package com.pack;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.pack.entity.Author;
import com.pack.entity.Book;
import com.pack.repository.AuthorRepository;
import com.pack.repository.BookRepository;

@SpringBootApplication
public class DatajpaManytomanyApplication   implements  CommandLineRunner{
	
	@Autowired
	ApplicationContext  ctx;

	public static void main(String[] args) {
		SpringApplication.run(DatajpaManytomanyApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		BookRepository  bookRepo=(BookRepository)ctx.getBean("bookRepository");
		AuthorRepository  authorRepo=(AuthorRepository)ctx.getBean("authorRepository");
		
		/*
		 * Book book1 =new Book(1, "java"); Book book2 =new Book(2, "oracle"); Book
		 * book3 =new Book(3, "python");
		 * 
		 * Author author1=new Author(101,"A"); Author author2=new Author(102,"B");
		 * Author author3=new Author(103,"C");
		 * 
		 * Set<Author> authorsSet1 =new HashSet<Author>(); authorsSet1.add(author1);
		 * authorsSet1.add(author2);
		 * 
		 * Set<Author> authorsSet2 =new HashSet<Author>(); authorsSet2.add(author1);
		 * authorsSet2.add(author2); authorsSet2.add(author3);
		 * 
		 * Set<Author> authorsSet3 =new HashSet<Author>(); authorsSet3.add(author2);
		 * authorsSet3.add(author3);
		 * 
		 * book1.setAuthors(authorsSet1); book2.setAuthors(authorsSet2);
		 * book3.setAuthors(authorsSet3);
		 * 
		 * bookRepo.save(book1); bookRepo.save(book2); bookRepo.save(book3);
		 */
		
		//Remove an author with id 103  from book with id 2
		/*
		 * Optional<Book> opt=bookRepo.findById(2);
		 *  Book book=opt.get();
		 *  Set<Author>  authors=book.getAuthors();
		 * 
		 * 
		 * Optional<Author> opt2 = authorRepo.findById(103);
		 *  Author author=opt2.get();
		 * 
		 * authors.remove(author);
		 */
		
		//add a new author  to a book with id 1
		
		Author   new_author=new  Author(104, "D");
		Optional<Book> opt=bookRepo.findById(1);
		Book   book = opt.get();
		Set<Author>   authors=book.getAuthors();
		
		authors.add(new_author);
		
		
		
		
		
		
		
		
	}

}
