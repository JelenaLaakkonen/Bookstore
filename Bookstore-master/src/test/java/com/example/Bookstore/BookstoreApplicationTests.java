package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.web.BookController;
import com.example.Bookstore.web.LoginController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
	private BookController bController;
	
	@Autowired
	private LoginController lController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(bController).isNotNull();
		assertThat(lController).isNotNull();
	}

}
