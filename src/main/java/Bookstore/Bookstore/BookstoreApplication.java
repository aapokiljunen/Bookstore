package Bookstore.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;
import Bookstore.Bookstore.domain.Category;
import Bookstore.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstore(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			categoryRepository.save(new Category("Fantasia"));
			categoryRepository.save(new Category("Romaani"));


			bookRepository.save(new Book("Taru sormusten herrasta", "J.R.R Tolkien", "56757 2436534 453", 1950, 3, 40.0, categoryRepository.findByName("Fantasia").get(0)));
			bookRepository.save(new Book("Arosusi", "Herman Hesse", "45654 6342 5543", 1955, 1, 35.0, categoryRepository.findByName("Romaani").get(0)));

			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};

	}
}
