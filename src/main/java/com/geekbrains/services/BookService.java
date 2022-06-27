package com.geekbrains.services;

import com.geekbrains.dto.BookDto;
import com.geekbrains.entities.Book;
import com.geekbrains.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить книгу, не надйен в базе, id: " + bookDto.getId()));
        book.setPrice(bookDto.getPrice());
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setAuthor(bookDto.getAuthor());
        return book;
    }
}
