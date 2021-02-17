package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository cRepository) {
		return (args) -> {
			
			Category c1 = new Category("Elämänkerta");
			Category c2 = new Category("Jännitys");
			
			cRepository.save(c1);
			cRepository.save(c2);
			
			Book book1 = new Book(c1, "Papan kanssa kahvilla", "Lotta-Sofia Saahko", 2020, "0000001", 14.90);
			Book book2 = new Book(c2 ,"Suon villi laulu", "Delia Owens", 2020, "0000002", 14.90);

			repository.save(book1);
			repository.save(book2);

		};
	}

}
