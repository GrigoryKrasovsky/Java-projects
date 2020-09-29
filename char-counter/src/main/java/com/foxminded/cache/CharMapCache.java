package com.foxminded.cache;

import java.util.HashMap;
import java.util.Map;

public class CharMapCache implements Cache<Map<Character, Integer>, String> {
    private final Map<String, Map<Character, Integer>> cache;

    public CharMapCache() {
        this(new HashMap<>());
    }

    public CharMapCache(Map<String, Map<Character, Integer>> cache) {
        this.cache = cache;
    }

    @Override
    public void put(String text, Map<Character, Integer> result) {
        cache.put(text, result);
    }

    @Override
    public Map<Character, Integer> get(String text) {
        return cache.get(text);
    }

    @Override
    public boolean contains(String text) {
        return cache.containsKey(text);
    }

}
