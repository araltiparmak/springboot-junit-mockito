package com.araltiparmak.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class JUnitExtensionMock {

    @Mock
    Map<String, String> mapMock;

    @Test
    void testMock() {
        mapMock.put("key", "val");
    }
}
