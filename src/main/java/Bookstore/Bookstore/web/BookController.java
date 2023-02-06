package Bookstore.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Bookstore.Bookstore.domain.Book;
import Bookstore.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired	
	private BookRepository bookRepository;
	
	@GetMapping({"/main", "/"})
	public String showMainPage() {
		System.out.println("testi");
		return "index";
	}
	
	@GetMapping("/booklist")
	public String showBookList(Model model) {
		model.addAttribute("booklist", bookRepository.findAll());		
		return "booklist";
		
	}
	
	@GetMapping("/addbook")
	public String addNewBook(Model model) {
		model.addAttribute("book", new Book());
		return "newbook";
		
	}
	
	@PostMapping("/saveBook")
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		return "editbook";
	}
	
	

}

