package ua.com.rtim.charcounter;

import java.util.Scanner;

public class Main {

	public static final String QUOTES = "\"";
	public static final String HYPHEN = "-";
	public static final String SPACE = " ";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the close for exit");
		CharCounter cache = new CharCounterCache(new UniqueCharCounter());
		while (!scanner.hasNext("close")) {
			String text = scanner.nextLine();
			if (text != null && !text.trim().isEmpty()) {
				System.out.println(text);
				cache.countChars(text).forEach((symbol, amount) -> System.out
						.println(QUOTES + symbol + QUOTES + SPACE + HYPHEN + SPACE + amount));
			}
		}
		System.out.println("Ok, good bye");
		scanner.close();
	}
}
