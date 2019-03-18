package com.araltiparmak.mockito.mock;

import com.araltiparmak.book.BookRepository;
import com.araltiparmak.book.BookService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InjectingMock {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

}
