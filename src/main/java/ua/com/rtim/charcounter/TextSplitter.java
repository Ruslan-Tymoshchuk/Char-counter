package ua.com.rtim.charcounter;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TextSplitter {

	public static final String TEXT_DELIMITER = "";

	public CountingResult splitToChars(String text) {
		List<String> chars = asList(text.split(TEXT_DELIMITER));
		Set<String> uniqueChars = new LinkedHashSet<>();
		uniqueChars.addAll(asList(text.split(TEXT_DELIMITER)));
		Map<String, Character> amountOfChars = new HashMap<>();
		uniqueChars.forEach(key -> amountOfChars.put(key, new Character(key, (countCharacter(chars, key)))));
		return new CountingResult(text, uniqueChars, amountOfChars);
	}

	private int countCharacter(List<String> chars, String symbol) {
		StringBuilder amount = new StringBuilder();
		for (int i = 0; i < chars.size(); i++) {
			String character = chars.get(i);
			if (character.equals(symbol)) {
				amount.append(symbol);
			}
		}
		return amount.length();
	}
}
