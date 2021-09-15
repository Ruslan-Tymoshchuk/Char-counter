package ua.com.rtim.charcounter;

import static java.lang.System.lineSeparator;

import java.util.Map;
import java.util.Set;

public class CharFormatter {

	public static final String INVERTED_COMMAS = "\"";
	public static final String HYPHEN_DELIMITER = "-";
	public static final String SPACE_DELIMITER = " ";

	public String format(CountingResult result) {
		StringBuilder format = new StringBuilder();
		String inputText = result.getText();
		format.append(inputText);
		Set<String> keys = result.getUniqueKeys();
		Map<String, Character> chars = result.getResult();
		keys.forEach(key -> format.append(buildHeader(chars.get(key))));
		return format.toString();
	}

	private String buildHeader(Character key) {
		StringBuilder format = new StringBuilder();
		String symbol = key.getSymbol();
		int amount = key.getAmount();
		format.append(lineSeparator());
		format.append(INVERTED_COMMAS + symbol + INVERTED_COMMAS);
		format.append(SPACE_DELIMITER);
		format.append(HYPHEN_DELIMITER);
		format.append(SPACE_DELIMITER);
		format.append(amount);
		return format.toString();
	}
}
