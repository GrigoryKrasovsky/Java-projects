package com.foxminded.decoratortest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.foxminded.cache.Cache;
import com.foxminded.charcounter.CharCounter;
import com.foxminded.charcounter.CounterDecorator;

@ExtendWith(MockitoExtension.class)
class DecoratorTest {
	@Mock
	Cache mcache;
	@Mock
	CharCounter mcharcounter;

	@InjectMocks
	CounterDecorator decorator = new CounterDecorator(mcache, mcharcounter);
	
	@Test
	void testDecorator1() {
		Map<Character, Integer> testmap = new HashMap<>();
		testmap.put('e', 1);
		testmap.put('h', 1);
		testmap.put('y', 1);
		when(decorator.count("hey")).thenReturn(testmap);
		assertEquals(decorator.count("hey"),testmap);
	}
	@Test
	void testDecorator2() {
		Map<Character, Integer> testmap = new HashMap<>();
		testmap.put('e', 1);
		testmap.put('h', 1);
		testmap.put('l', 2);
		testmap.put('0', 1);
		when(decorator.count("hello")).thenReturn(testmap);
		assertEquals(decorator.count("hello"),testmap);

	}
	@Test
	void testWhenCacheIsNotEmpty() {
		Map<Character, Integer> helloEntry = new HashMap<>();
		helloEntry.put('e', 1);
		helloEntry.put('h', 1);
		helloEntry.put('l', 2);
		helloEntry.put('0', 1);
		mcache.putText("hello", helloEntry);
		when(decorator.count("hello")).thenReturn(helloEntry);
		
	}
}
