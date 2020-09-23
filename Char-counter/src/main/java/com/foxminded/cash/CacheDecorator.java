package com.foxminded.cash;

import java.util.Map;

import com.foxminded.CharCounter.CharCounter;

public class CacheDecorator implements CharCounter{

	@Override
	public Map<Character, Integer> count(String text) {
		Cache cache = new Cache();
		return cache.getText(text);
	}
}
