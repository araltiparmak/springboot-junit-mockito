package com.araltiparmak.springbootjunitmockito.mockitosample;

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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

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
    public void findByIdBDD() {
        //given
        Book anyBook = new Book(1, "AnyBook");
        given(bookRepository.findById(1)).willReturn(Optional.of(anyBook));

        //when
        Book foundBook = bookService.findById(1);

        //then
        assertThat(anyBook).isNotNull();
        assertEquals(anyBook, foundBook);
//        then(bookRepository).should().findById(anyInt());
        then(bookRepository).should(times(1)).findById(anyInt());
        then(bookRepository).shouldHaveNoMoreInteractions();
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
