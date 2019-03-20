package com.araltiparmak.springbootjunitmockito.mockitosample.mock;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class InlineMock {

    @Test
    void testMock() {

        Set setMock = mock(Set.class);

        assertEquals(setMock.size(), 0);
    }
}
