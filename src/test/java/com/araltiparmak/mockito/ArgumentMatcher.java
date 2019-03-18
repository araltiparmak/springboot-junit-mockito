package com.araltiparmak.mockito;

import com.araltiparmak.book.Book;
import com.araltiparmak.book.BookRepository;
import com.araltiparmak.book.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArgumentMatcher {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    public void findById() {
        Book anyBook = new Book(2, "AnyBook");
        when(bookRepository.findById(anyInt())).thenReturn(Optional.of(anyBook));
        Book book = bookService.findById(1);

        assertThat(anyBook).isNotNull();
        assertEquals(anyBook, book);
        verify(bookRepository).findById(anyInt());
    }

    @Test
    public void delete() {
        Book book = new Book(2, "Book");
        bookService.delete(book);

        verify(bookRepository).delete(any(Book.class));
    }

    @Test
    public void save() {
        Book book = new Book(3, "Book");
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book savedBook = bookService.save(book);

        verify(bookRepository).save(any(Book.class));
        assertThat(savedBook).isNotNull();
    }
}
