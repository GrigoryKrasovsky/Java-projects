package com.foxminded.charcounter;

import java.util.Map;

import com.foxminded.cache.Cache;


public class CounterDecorator implements CharCounter{
	Cache cache;
	CharCounter counter;
	public CounterDecorator(Cache cache, CharCounter counter) {
		this.cache = cache;
		this.counter=counter;
	}

	@Override
	public Map<Character, Integer> count(String text) {
		if(!cache.contains(text)) {
			System.out.println("cache doesn't contain the text");
			cache.putText(text, counter.count(text));
		}
		return cache.getText(text);
	}
}

