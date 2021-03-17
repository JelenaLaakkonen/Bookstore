package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bRepository, CategoryRepository cRepository, UserRepository uRepository) {
		return (args) -> {

			Category c1 = new Category("Elämänkerta");
			Category c2 = new Category("Jännitys");

			cRepository.save(c1);
			cRepository.save(c2);

			Book book1 = new Book(c1, "Papan kanssa kahvilla", "Lotta-Sofia Saahko", 2020, "0000001", 14.90);
			Book book2 = new Book(c2, "Suon villi laulu", "Delia Owens", 2020, "0000002", 14.90);

			bRepository.save(book1);
			bRepository.save(book2);

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@user.fi","USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@admin.fi", "ADMIN");
			
			uRepository.save(user1);
			uRepository.save(user2);
		};
	}

}
