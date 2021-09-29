package ua.com.rtim.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CachedCharCounterTest {

	@Mock
	private CharCounter сharCounter;
	@InjectMocks
	private CachedCharCounter cachedCharCounter;

	@Test
	void givenSameTextTwice_whenCountChars_thenUnderlyingCharCounterCalledOnce() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('2', 1);
		expected.put('0', 2);
		expected.put('l', 3);
		expected.put('o', 1);
		when(сharCounter.countChars("he20lllo0")).thenReturn(expected);
		assertEquals(expected, cachedCharCounter.countChars("he20lllo0"));
		assertEquals(expected, cachedCharCounter.countChars("he20lllo0"));
		verify(сharCounter, times(1)).countChars("he20lllo0");
	}
}