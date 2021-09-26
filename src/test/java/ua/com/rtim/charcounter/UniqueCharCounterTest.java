package ua.com.rtim.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class UniqueCharCounterTest {

	private UniqueCharCounter uniqueCharCounter = new UniqueCharCounter();

	@Test
	void givenEmptyString_whenCountChars_thenEmptyString() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		assertEquals(expected, uniqueCharCounter.countChars(""));
	}

	@Test
	void givenOnlySpace_whenCountChars_thenSingleSpace() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put(' ', 1);
		assertEquals(expected, uniqueCharCounter.countChars(" "));
	}

	@Test
	void givenTwoSpaces_whenCountChars_thenAmountOfSpacesIsTwo() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put(' ', 2);
		assertEquals(expected, uniqueCharCounter.countChars("  "));
	}

	@Test
	void givenFiveSpaces_whenCountChars_thenAmountOfSpacesIsFive() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put(' ', 5);
		assertEquals(expected, uniqueCharCounter.countChars("     "));
	}

	@Test
	void givenSomeNonLetterChars_whenCountChars_thenAmountOfChars() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('2', 1);
		expected.put('0', 2);
		expected.put('l', 3);
		expected.put('o', 1);
		assertEquals(expected, uniqueCharCounter.countChars("he20lllo0"));
	}

	@Test
	void givenLettersInMixedCase_whenCountChars_thenAmountOfChars() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('m', 2);
		expected.put('K', 3);
		expected.put('f', 3);
		expected.put('M', 3);
		expected.put('O', 3);
		expected.put('o', 2);
		expected.put('F', 2);
		expected.put(' ', 2);
		expected.put('k', 3);
		assertEquals(expected, uniqueCharCounter.countChars("mKfMOfKoF KOkfMokF MkmO"));
	}

	@Test
	void givenSomeNonLetterCharsInMixedCase_whenCountChars_thenAmountOfChars() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('Y', 1);
		expected.put('4', 1);
		expected.put('a', 2);
		expected.put('!', 3);
		expected.put('j', 3);
		expected.put('E', 2);
		expected.put('e', 1);
		expected.put('m', 1);
		expected.put('A', 2);
		expected.put('T', 1);
		expected.put('1', 1);
		assertEquals(expected, uniqueCharCounter.countChars("Y4a!jEeE!amAT!j1jA"));
	}

	@Test
	void givenNull_whenCountChars_thenException() {
		assertThrows(NullPointerException.class, () -> uniqueCharCounter.countChars(null));
	}
}
