package ua.com.rtim.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class UniqueCharCounterTest {

	private UniqueCharCounter uniqueCharCounter = new UniqueCharCounter();
	private Map<Character, Integer> expected = new LinkedHashMap<>();

	@Test
	void givenOnlySpaces_whenCountChars_thenAmountOfSpaces() {
		expected.put(' ', 3);
		assertEquals(expected, uniqueCharCounter.countChars("   "));
	}

	@Test
	void givenSomeNonLetterChars_whenCountChars_thenAmountOfChars() {
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('2', 1);
		expected.put('0', 2);
		expected.put('l', 3);
		expected.put('o', 1);
		assertEquals(expected, uniqueCharCounter.countChars("he20lllo0"));
	}

	@Test
	void givenNull_whenCountChars_thenException() {
		assertThrows(NullPointerException.class, () -> uniqueCharCounter.countChars(null));
	}
}
