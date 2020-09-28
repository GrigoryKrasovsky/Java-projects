package com.foxminded.charcounter;

import com.foxminded.cache.Cache;
import com.foxminded.cache.CharMapCache;

import java.util.Map;


public class CachingCharCounterDecorator implements CharCounter {
    private final Cache<Map<Character, Integer>, String> cache;
    private final CharCounter counter;

    public CachingCharCounterDecorator(CharCounter counter) {
        this(new CharMapCache(), counter);
    }

    public CachingCharCounterDecorator(Cache<Map<Character, Integer>, String> cache, CharCounter counter) {
        this.cache = cache;
        this.counter = counter;
    }

    @Override
    public Map<Character, Integer> count(String text) {
        if (!cache.contains(text)) {
            cache.put(text, counter.count(text));
        }
        return cache.get(text);
    }
}

