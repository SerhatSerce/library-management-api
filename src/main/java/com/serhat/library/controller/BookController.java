package com.serhat.library.controller;

import com.serhat.library.dto.BookRequest;
import com.serhat.library.dto.BookResponse;
import com.serhat.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse addBook(@Valid @RequestBody BookRequest dto) {
        return bookService.addBook(dto);
    }

    // READ ALL
    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable Long id,
                                   @Valid @RequestBody BookRequest dto) {
        return bookService.updateBook(id, dto);
    }
}