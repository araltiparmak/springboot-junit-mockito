package com.araltiparmak.springbootjunitmockito.mockitosample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class When {

    @Mock
    BookRepository bookRepository;

    @Test
    public void testWhen() {
        Book myBook = new Book(1, "MyBook");
        when(bookRepository.findById(1)).thenReturn(Optional.of(myBook));

        assertThat(myBook).isNotNull();
        assertEquals(myBook, bookRepository.findById(1).get());
        verify(bookRepository).findById(1);
    }
}
