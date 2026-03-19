package com.serhat.library.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequest {

    @NotBlank(message = "Title boş olamaz")
    private String title;

    @NotBlank(message = "Author boş olamaz")
    private String author;
}