package com.serhat.library.service;
import com.serhat.library.dto.BookRequest;
import com.serhat.library.entity.Book;
import com.serhat.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // READ
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // DELETE
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // UPDATE
    public Book updateBook(Long id, BookRequest dto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return bookRepository.save(book);
    }
}