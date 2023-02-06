package Bookstore.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository bookRepository) {
		return (args) -> {
		
		bookRepository.save(new Book("Taru sormusten herrasta", "J.R.R Tolkien", "56757 2436534 453", 1950, 33.0, 4));
		bookRepository.save(new Book("Arosusi", "Herman Hesse", "45654 6342 5543", 1955, 12.0, 5));
		
		};
		
	}
}
