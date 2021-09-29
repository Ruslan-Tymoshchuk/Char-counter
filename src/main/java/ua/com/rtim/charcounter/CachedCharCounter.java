package ua.com.rtim.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharCounter extends CharCounterDecorator {

	private Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();

	public CachedCharCounter(CharCounter charCounter) {
		super(charCounter);
	}

	@Override
	public Map<Character, Integer> countChars(String text) {
		return cache.computeIfAbsent(text, amountUniqueChars -> super.countChars(text));
	}
}
