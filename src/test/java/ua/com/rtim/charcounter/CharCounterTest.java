package ua.com.rtim.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class CharCounterTest {

	private Map<String, Map<Character, Integer>> cache = new LinkedHashMap<>();
	private Map<Character, Integer> expected = new LinkedHashMap<>();

	@Mock
	CharCounter charCounter;

	@Test
	void givenSomeNonLetterChars_whenCountChars_thenAmountChars() {
		when(charCounter.countChars("he20lllo0")).thenReturn(cache.get("he20lllo0"))
				.thenThrow(IllegalArgumentException.class);
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('2', 1);
		expected.put('0', 2);
		expected.put('l', 3);
		expected.put('o', 1);
		when(charCounter.countChars("he20lllo0")).thenReturn(cache.put("he20lllo0", expected));
		when(charCounter.countChars("he20lllo0")).thenReturn(cache.get("he20lllo0"));
		assertEquals(expected, charCounter.countChars("he20lllo0"));
		assertEquals(expected, charCounter.countChars("he20lllo0"));
		verify(charCounter, times(2)).countChars("he20lllo0");
	}

	@Test
	void givenSimilarChars_whenCountChars_thenAmountOfThisChar() {
		when(charCounter.countChars("hhhh")).thenReturn(cache.get("hhhh")).thenThrow(IllegalArgumentException.class);
		expected.put('h', 4);
		when(charCounter.countChars("hhhh")).thenReturn(cache.put("hhhh", expected));
		when(charCounter.countChars("hhhh")).thenReturn(cache.get("hhhh"));
		assertEquals(expected, charCounter.countChars("hhhh"));
		assertEquals(expected, charCounter.countChars("hhhh"));
		verify(charCounter, times(2)).countChars("hhhh");
	}
}