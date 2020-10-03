package com.foxminded.charcounter;

import java.util.Map;

public interface CharCounter {
    Map<Character, Integer> count(String text);
}
