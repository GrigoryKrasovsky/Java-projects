package com.foxminded.anagram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnagramTest {
    Anagram anagram = new Anagram();

    private static Stream<Arguments> provideStringForAnagramTest() {
        return Stream.of(
                Arguments.of("Hello world", "olleH dlrow"),
                Arguments.of("Hello123 wor@ld!", "olleH123 dlr@ow!"),
                Arguments.of("World", "dlroW")
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringForAnagramTest")
    void testAnagrams(String input, String expected) {
        assertEquals(expected, anagram.process(input));
    }

    @Test
    void testExpectedException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> anagram.process(null));
    }
}
