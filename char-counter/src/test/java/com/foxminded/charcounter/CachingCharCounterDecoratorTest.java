package com.foxminded.charcounter;

import com.foxminded.cache.CharMapCache;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachingCharCounterDecoratorTest {
	public static final String TEST = "test";
	public static final Map<Character, Integer> testMap = Map.of('s', 1, 't', 2, 'e', 1);

	@Mock
	CharMapCache cache;

	@Mock
	CharCounter counter;

	@InjectMocks
	CachingCharCounterDecorator decorator;

	@Test
	void shouldGetValueFromCache() {
		when(cache.contains("test")).thenReturn(true);
		when(cache.get(TEST)).thenReturn(new HashMap<>(testMap));
		assertEquals(testMap, decorator.count(TEST));
		verify(counter, never()).count(anyString());
	}

	@Test
	void shouldGetValueFromCounter() {
		when(cache.contains(anyString())).thenReturn(false, true);
		HashMap<Character, Integer> cached = new HashMap<>(testMap);
		when(cache.get(TEST)).thenReturn(cached);
		when(counter.count(TEST)).thenReturn(cached);
		assertEquals(testMap, decorator.count(TEST));
		verify(counter, times(1)).count(TEST);
		verify(cache, times(1)).put(TEST, testMap);
	}
}
