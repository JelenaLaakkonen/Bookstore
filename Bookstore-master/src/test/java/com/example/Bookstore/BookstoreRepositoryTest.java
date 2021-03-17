package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {

	@Autowired
	private BookRepository bRepository;

	@Autowired
	private CategoryRepository cRepository;

	@Autowired
	private UserRepository uRepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bRepository.findByTitle("Papan kanssa kahvilla");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Lotta-Sofia Saahko");
	}

	@Test
	public void createNewBook() {
		Book book = new Book(new Category("Fantasia"), "Soturikissat", "Erin Hunter", 2008, "0000004", 12.00);
		bRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBook() {
		List<Book> books = bRepository.findByTitle("Papan kanssa kahvilla");
		bRepository.deleteAll(books);
		assertThat(books.isEmpty());
	}

	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = cRepository.findByName("Jännitys");
		assertThat(categories).hasSize(1);
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Kauhu");
		cRepository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}

	@Test
	public void deleteCategory() {
		List<Category> categories = cRepository.findByName("Jännitys");
		cRepository.deleteAll(categories);
		assertThat(categories.isEmpty());
	}

	@Test
	public void findByUserNameShouldReturnUser() {
		User user = uRepository.findByUsername("user");
		assertThat(user.getEmail()).isEqualTo("user@user.fi");
	}

	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user2@user.fi", "USER");
		uRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteUser() {
		User user = uRepository.findByUsername("user");
		uRepository.deleteById(user.getId());
		assertThat(uRepository.findByUsername("user")).isNull();
	}

}
