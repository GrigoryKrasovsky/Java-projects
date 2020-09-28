package com.foxminded.charcounter;

import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.foxminded.cache.Cache;
import com.foxminded.charcounter.BasicCharCounter;
import com.foxminded.charcounter.CharCounter;
import com.foxminded.charcounter.CounterDecorator;

@ExtendWith(MockitoExtension.class)
class DecoratorTest {
	BasicCharCounter basicCounter = new BasicCharCounter();
	Map <Character, Integer> testMap = Map.of('s',1, 't', 2, 'e', 1);
	
	@Mock
	Cache cacheMock;
	@Mock
	CharCounter charcounterMock;

	@InjectMocks
	CounterDecorator decorator;


	@Test
	void verifyStringIsNotPutIntoCacheWhenCacheHasThisString() {
		when(cacheMock.contains("test")).thenReturn(true);
		decorator.count("test");
		verify(cacheMock, never()).putText("test", Map.of('s',1, 't', 2, 'e', 1));
	}
	@Test
	void verifyCounterIsNotUsedWhenCacheHasTheString() {
		when(cacheMock.contains("test")).thenReturn(true);
		decorator.count("test");
		verify(charcounterMock, never()).count("test");
	}
	@Test
	void verifyTheProperStringIsReturnedWhenCacheHasThisString() {
		when(cacheMock.contains("test")).thenReturn(true);
		when(cacheMock.getText("test")).thenReturn(testMap);
		decorator.count("test");
		assertEquals(testMap,decorator.count("test"));
	}
	
	@Test
	void verifyStringIsPutIntoCacheWhenCacheHasNotThisString() {
		when(cacheMock.contains("test")).thenReturn(false);
		decorator.count("test");
		verify(cacheMock, atLeastOnce()).putText("test", Map.of());
	}
	@Test
	void verifyCounterIsUsedWhenCacheHasNotTheString() {
		when(cacheMock.contains("test")).thenReturn(false);
		decorator.count("test");
		verify(charcounterMock, atLeastOnce()).count("test");
	}
	@Test
	void verifyTheProperStringIsReturnedWhenCacheHasNotThisString() {
		when(cacheMock.contains("test")).thenReturn(false);
		when(cacheMock.getText("test")).thenReturn(testMap);
		decorator.count("test");
		assertEquals(testMap,decorator.count("test"));
	}
}
