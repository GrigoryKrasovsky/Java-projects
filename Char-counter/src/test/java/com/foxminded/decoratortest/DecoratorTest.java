package com.foxminded.decoratortest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
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
	CounterDecorator decorator;
	

	@Test
	void testWhenCacheIsEmpty() {
		Map<Character, Integer> testMap = Collections.emptyMap();
		mcache.putText("some string",testMap);
		verify(mcache, atLeastOnce()).putText("some string", testMap);
	}
	@Test
	void testWhenCacheIsNotEmpty() {
		Map<Character, Integer> testMap = Collections.emptyMap();
		verify(mcache, never()).putText("some string", testMap);
	}
}
