package com.gl.springboot.Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.springboot.Library.entity.Book;
import com.gl.springboot.Library.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/add")
	private void addBook(@RequestBody Book book) {
		bookService.save(book);
	}

	@GetMapping("/list")
	private String getAllBooks(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("books", bookList);

		return "books/list-books";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Book book = new Book();

		model.addAttribute("book", book);
		return "books/book-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int id, Model model) {
		Book bookDetails = bookService.findById(id);
		model.addAttribute("book", bookDetails);
		return "books/book-form";

	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.save(book);
		return "redirect:/books/list";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("bookId") int id) {
		bookService.deleteById(id);
		return "redirect:/books/list";
	}

}