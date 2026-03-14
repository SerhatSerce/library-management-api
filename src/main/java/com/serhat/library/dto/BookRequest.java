package com.serhat.library.dto;

import jakarta.validation.constraints.NotBlank;

public class BookRequest {

    @NotBlank(message = "Title boş olamaz")
    private String title;

    @NotBlank(message = "Author boş olamaz")
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}