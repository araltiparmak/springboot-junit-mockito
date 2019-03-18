package com.araltiparmak.mockito;

import com.araltiparmak.book.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class Verify {

    @Mock
    BookService bookService;

    @Test
    void testOnce() {
        bookService.findAll();

        verify(bookService).findAll();
    }

    @Test
    void testTimes() {
        bookService.findAll();
        bookService.findAll();
        bookService.findAll();

        verify(bookService, times(3)).findAll();
    }

    @Test
    void testAtLeastOnce() {
        bookService.findAll();
        bookService.findAll();

        verify(bookService, atLeastOnce()).findAll();
    }

    @Test
    void testAtLeastTwo() {
        bookService.findAll();
        bookService.findAll();

        verify(bookService, atLeast(2)).findAll();
    }

    @Test
    void testAtMostTwo() {
        bookService.findAll();

        verify(bookService, atMost(2)).findAll();
    }

    @Test
    void testNever() {
        verify(bookService, never()).findAll();
    }
}
