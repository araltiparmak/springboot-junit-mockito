package com.araltiparmak.springbootjunitmockito.mockitosample.mock;

import com.araltiparmak.springbootjunitmockito.mockitosample.BookRepository;
import com.araltiparmak.springbootjunitmockito.mockitosample.BookService;
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
