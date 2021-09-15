package ua.com.rtim.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class TextSplitterTest {

	TextSplitter splitter = new TextSplitter();

	@Test
	void givenText_whenSplitToChars_thenNewEqualObject() {
		Set<String> uniqueChars = new LinkedHashSet<>();
		uniqueChars.add("!");
		uniqueChars.add("h");
		uniqueChars.add("e");
		uniqueChars.add("l");
		uniqueChars.add("o");
		Map<String, Character> amountOfChars = new HashMap<>();
		amountOfChars.put("!", new Character("!", 1));
		amountOfChars.put("e", new Character("e", 1));
		amountOfChars.put("h", new Character("h", 1));
		amountOfChars.put("l", new Character("l", 2));
		amountOfChars.put("o", new Character("o", 1));
		CountingResult expected = new CountingResult("!hello", uniqueChars, amountOfChars);
		assertEquals(expected, splitter.splitToChars("!hello"));
	}

	@Test
	void givenText_whenSplitToChars_thenNullObject() {
		assertThrows(NullPointerException.class, () -> splitter.splitToChars(null));
	}
}
