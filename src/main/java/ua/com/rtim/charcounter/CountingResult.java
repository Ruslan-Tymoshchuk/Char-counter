package ua.com.rtim.charcounter;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CountingResult {

	private final String text;
	private final Set<String> uniqueKeys;
	private final Map<String, Character> result;

	public CountingResult(String text, Set<String> uniqueKeys, Map<String, Character> result) {
		this.text = text;
		this.uniqueKeys = uniqueKeys;
		this.result = result;
	}

	public String getText() {
		return text;
	}

	public Set<String> getUniqueKeys() {
		return uniqueKeys;
	}

	public Map<String, Character> getResult() {
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountingResult countingResult = (CountingResult) obj;
		return Objects.equals(text, countingResult.text);
	}
}
