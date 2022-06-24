package com.geekbrains.converters;

import com.geekbrains.dto.BookDto;
import com.geekbrains.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    public Book dtoToEntity(BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getGenre(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPrice());
    }

    public BookDto entityToDto(Book book) {
        return new BookDto(book.getId(), book.getGenre(), book.getTitle(), book.getAuthor(), book.getPrice());
    }
}
