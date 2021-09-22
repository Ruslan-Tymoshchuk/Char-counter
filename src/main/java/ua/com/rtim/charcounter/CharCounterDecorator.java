package ua.com.rtim.charcounter;

import java.util.Map;

public class CharCounterDecorator implements CharCounter {

	CharCounter charCounter;

	public CharCounterDecorator(CharCounter charCounter) {
		this.charCounter = charCounter;
	}

	@Override
	public Map<Character, Integer> countChars(String text) {
		return charCounter.countChars(text);
	}
}
