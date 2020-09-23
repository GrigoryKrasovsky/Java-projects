package com.foxminded.CharCounter;

import java.util.HashMap;
import java.util.Map;

public class BasicCharCounter implements CharCounter{
	public Map <Character, Integer> count (String text) {
		Map <Character, Integer> result = new HashMap<>();
		for (int i =0; i<text.length();i++) {
			if(!result.containsKey(text.charAt(i))) {
				result.put(text.charAt(i),1);
			}else {
				int value = result.get(text.charAt(i));
				result.replace(text.charAt(i), value+1);
			}
		}
		
		return result;
		
		
	}
}
