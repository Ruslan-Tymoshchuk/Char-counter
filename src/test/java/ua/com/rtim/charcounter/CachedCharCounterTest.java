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

class CachedCharCounterTest {

	@Mock
	private CachedCharCounter cachedCharCounter;

	@Test
	void givenSomeNonLetterChars_whenCountChars_thenAmountChars() {
		when(cachedCharCounter.countChars("he20lllo0")).thenReturn(null).thenThrow(IllegalArgumentException.class);
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('2', 1);
		expected.put('0', 2);
		expected.put('l', 3);
		expected.put('o', 1);
		when(cachedCharCounter.countChars("he20lllo0")).thenReturn(expected);
		assertEquals(expected, cachedCharCounter.countChars("he20lllo0"));
		assertEquals(expected, cachedCharCounter.countChars("he20lllo0"));
		verify(cachedCharCounter, times(2)).countChars("he20lllo0");
	}

	@Test
	void givenSimilarChars_whenCountChars_thenAmountOfThisChar() {
		when(cachedCharCounter.countChars("hhhh")).thenReturn(null).thenThrow(IllegalArgumentException.class);
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('h', 4);
		when(cachedCharCounter.countChars("hhhh")).thenReturn(expected);
		assertEquals(expected, cachedCharCounter.countChars("hhhh"));
		assertEquals(expected, cachedCharCounter.countChars("hhhh"));
		verify(cachedCharCounter, times(2)).countChars("hhhh");
	}
}