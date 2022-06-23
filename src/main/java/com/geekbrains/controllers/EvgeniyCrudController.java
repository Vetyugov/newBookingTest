package com.geekbrains.controllers;


import com.geekbrains.converters.BookConverter;
import com.geekbrains.dto.BookDto;
import com.geekbrains.entities.Book;
import com.geekbrains.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class EvgeniyCrudController {
    private final BookService bookService;
    private final BookConverter bookConverter;

    @GetMapping
    public List<BookDto> getAllBooks(){
        return bookService.findAll().stream().map(p->bookConverter.entityToDto(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book Book = bookService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found, id: " + id));
        return bookConverter.entityToDto(Book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping
    public BookDto saveNewBook(@RequestBody BookDto bookDto) {
        //BookValidator.validate(BookDto);
        Book book = bookConverter.dtoToEntity(bookDto);
        book = bookService.save(book);
        return bookConverter.entityToDto(book);
    }

    @PutMapping
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        //BookValidator.validate(BookDto);
        Book book = bookService.update(bookDto);
        return bookConverter.entityToDto(book);
    }
    
}
