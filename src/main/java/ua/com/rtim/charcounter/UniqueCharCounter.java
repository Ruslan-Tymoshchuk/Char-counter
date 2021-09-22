package ua.com.rtim.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharCounter implements CharCounter {

	public Map<Character, Integer> countChars(String text) {
		Map<Character, Integer> amountUniqueChars = new LinkedHashMap<>();
		text.chars().forEach(charAsInt -> amountUniqueChars.merge((char) charAsInt, 1, Integer::sum));
		return amountUniqueChars;
	}
}
