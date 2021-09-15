package ua.com.rtim.charcounter;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CharFormatterTest {

	private CharFormatter formatter = new CharFormatter();
	private TextSplitter splitter = new TextSplitter();

	@Test
	void givenNull_whenFormat_thenNullPointerException() {
		assertThrows(NullPointerException.class, () -> formatter.format(null));
	}

	@Test
	void given_lettersWithSymbols_whenFormat_thenResultOfCount() {
		StringBuilder expected = new StringBuilder();
		expected.append("!hello world!" + lineSeparator());
		expected.append("\"!\" - 2" + lineSeparator());
		expected.append("\"h\" - 1" + lineSeparator());
		expected.append("\"e\" - 1" + lineSeparator());
		expected.append("\"l\" - 3" + lineSeparator());
		expected.append("\"o\" - 2" + lineSeparator());
		expected.append("\" \" - 1" + lineSeparator());
		expected.append("\"w\" - 1" + lineSeparator());
		expected.append("\"r\" - 1" + lineSeparator());
		expected.append("\"d\" - 1");
		assertEquals(expected.toString(), formatter.format(splitter.splitToChars("!hello world!")));
	}

	@Test
	void given_lettersWithDigits_whenFormat_thenResultOfCount() {
		StringBuilder expected = new StringBuilder();
		expected.append("K2I234O340TLyHkO220" + lineSeparator());
		expected.append("\"K\" - 1" + lineSeparator());
		expected.append("\"2\" - 4" + lineSeparator());
		expected.append("\"I\" - 1" + lineSeparator());
		expected.append("\"3\" - 2" + lineSeparator());
		expected.append("\"4\" - 2" + lineSeparator());
		expected.append("\"O\" - 2" + lineSeparator());
		expected.append("\"0\" - 2" + lineSeparator());
		expected.append("\"T\" - 1" + lineSeparator());
		expected.append("\"L\" - 1" + lineSeparator());
		expected.append("\"y\" - 1" + lineSeparator());
		expected.append("\"H\" - 1" + lineSeparator());
		expected.append("\"k\" - 1");
		assertEquals(expected.toString(), formatter.format(splitter.splitToChars("K2I234O340TLyHkO220")));
	}
}
