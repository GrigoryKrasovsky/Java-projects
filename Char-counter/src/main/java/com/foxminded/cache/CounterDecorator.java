package com.foxminded.cache;

import java.util.Map;

import com.foxminded.CharCounter.BasicCharCounter;
import com.foxminded.CharCounter.CharCounter;

public class CounterDecorator implements CharCounter{
	Cache cache;
	CharCounter counter;
	public CounterDecorator(Cache cache, CharCounter counter) {
		cache = this.cache;
		counter = this.counter;
	}

	@Override
	public Map<Character, Integer> count(String text) {
		System.out.println(cache.contains(text));
		counter.count(text);
		cache.putText(text, counter.count(text));
		return cache.getText(text);
	}
}

