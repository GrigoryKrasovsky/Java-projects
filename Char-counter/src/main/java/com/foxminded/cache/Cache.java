package com.foxminded.cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	private Map <String, Map<Character, Integer>> cache = new HashMap <>();
	
	public void putText(String text, Map <Character, Integer> result) {
		cache.put(text, result);
	}
	
	public Map<Character, Integer> getText(String text) {
		return cache.get(text);
	}
	
	public boolean contains(String text) {
		return cache.containsKey(text);
	}
	
}
