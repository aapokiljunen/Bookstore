package Bookstore.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Bookstore.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired	
	private BookRepository bookRepository;
	
	@GetMapping("/main")
	public String showMainPage() {
		System.out.println("testi");
		return "index";
	}
	
	@GetMapping("/booklist")
	public String showBookList(Model model) {
		model.addAttribute("booklist", bookRepository.findAll());		
		return "booklist";
		
	}
	
	
	

}

