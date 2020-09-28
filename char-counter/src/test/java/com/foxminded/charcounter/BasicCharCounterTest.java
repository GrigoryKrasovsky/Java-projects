package com.foxminded.charcounter;


import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCharCounterTest {
	BasicCharCounter basicCounter = new BasicCharCounter();
	
	@Test
	void verifyBasicCounterReturnsProperResult() {
		Map <Character, Integer> testMap = Map.of('s',1, 't', 2, 'e', 1);
		assertEquals(testMap,basicCounter.count("test"));
	}
}
