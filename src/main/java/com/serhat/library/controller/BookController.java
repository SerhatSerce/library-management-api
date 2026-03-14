package com.serhat.library.controller;

import com.serhat.library.dto.BookRequest;
import com.serhat.library.entity.Book;
import com.serhat.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CREATE
    @PostMapping
    public Book addBook(@Valid @RequestBody BookRequest dto) {

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return bookService.addBook(book);
    }

    // READ
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @Valid @RequestBody BookRequest dto) {

        return bookService.updateBook(id, dto);
    }
}