package com.serhat.library.controller;

import jakarta.validation.Valid;
import com.serhat.library.dto.BookRequest;
import com.serhat.library.entity.Book;
import com.serhat.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // kitap ekleme
    @PostMapping
    public Book addBook(@Valid @RequestBody BookRequest dto) {

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return bookService.addBook(book);
    }

    // tüm kitapları listeleme
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // kitap silme
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    // kitap güncelleme
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @Valid @RequestBody BookRequest dto) {

        Book book = new Book();
        book.setId(id);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return bookService.updateBook(book);
    }
}