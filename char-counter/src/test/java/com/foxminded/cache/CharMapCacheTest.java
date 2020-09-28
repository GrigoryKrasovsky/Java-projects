package com.foxminded.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CharMapCacheTest {

    public static final String TEST = "TEST";
    public static final Map<Character, Integer> testMap = Map.of('a', 1);

    @Mock
    Map<String, Map<Character, Integer>> map;

    @InjectMocks
    CharMapCache cache;

    @Test
    void shouldGetValueFromCache() {
        when(map.get(TEST)).thenReturn(new HashMap<>(testMap));
        assertEquals(testMap, cache.get(TEST));
    }

    @Test
    void shouldReturnNullIfEmpty() {
        assertNull(cache.get(TEST));
    }

    @Test
    void shouldStoreValueIntoCache() {
        cache.put(TEST, testMap);
        verify(map, times(1)).put(TEST, testMap);
    }
}