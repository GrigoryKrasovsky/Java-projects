package com.foxminded.charcounter;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.foxminded.charcounter.BasicCharCounter;

public class BasicCounterTest {
	BasicCharCounter basicCounter = new BasicCharCounter();
	
	@Test
	void verifyBasicCounterReturnsProperResult() {
		Map <Character, Integer> testMap = Map.of('s',1, 't', 2, 'e', 1);
		assertEquals(testMap,basicCounter.count("test"));
	}
}
