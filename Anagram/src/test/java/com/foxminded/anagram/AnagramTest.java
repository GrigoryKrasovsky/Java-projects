package com.foxminded.anagram;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AnagramTest {
	Anagram anagram = new Anagram();
	
	@ParameterizedTest
	@MethodSource("provideStringForAnagramTest")
	void testAnagrams(String input, String expected) {
		assertEquals(expected, anagram.process(input));
	}
	private static Stream <Arguments> provideStringForAnagramTest(){
		return Stream.of(
				Arguments.of("Hello world","olleH dlrow"),
				Arguments.of("Hello123 wor@ld!","olleH123 dlr@ow!"),
				Arguments.of("World", "dlroW")
				);
	}
	
	@Test
	void testExpectedException() {
	 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    anagram.process(null);
	  });
	}
}
