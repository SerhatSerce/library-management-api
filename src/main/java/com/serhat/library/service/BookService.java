package com.serhat.library.service;

import com.serhat.library.dto.BookRequest;
import com.serhat.library.dto.BookResponse;
import com.serhat.library.entity.Book;
import com.serhat.library.exception.BookNotFoundException;
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
    public BookResponse addBook(BookRequest dto) {

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        Book saved = bookRepository.save(book);

        return new BookResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getAuthor()
        );
    }

    // READ ALL
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(book -> new BookResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor()
                ))
                .toList();
    }

    // READ BY ID
    public BookResponse getBookById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor()
        );
    }

    // DELETE
    public void deleteBook(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.delete(book);
    }

    // UPDATE
    public BookResponse updateBook(Long id, BookRequest dto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        Book updated = bookRepository.save(book);

        return new BookResponse(
                updated.getId(),
                updated.getTitle(),
                updated.getAuthor()
        );
    }
}