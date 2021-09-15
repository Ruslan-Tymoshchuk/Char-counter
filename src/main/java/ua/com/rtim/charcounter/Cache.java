package ua.com.rtim.charcounter;

import java.util.HashMap;
import java.util.Map;

public class Cache {
	private Map<String, CountingResult> cacheResult = new HashMap<>();

	public CountingResult requaireCache(String text, TextSplitter splitter) {
		return cacheResult.computeIfAbsent(text, textResult -> splitter.splitToChars(text));
	}
}
