package ua.com.rtim.charcounter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter text to count the number of chars");
		CharCounter charCounter = new CachedCharCounter(new UniqueCharCounter());
		while (scanner.hasNextLine()) {
			String text = scanner.nextLine();
			System.out.println(text);
			String amountChars = "\"%c\" - %d";
			charCounter.countChars(text)
					.forEach((symbol, amount) -> System.out.println(String.format(amountChars, symbol, amount)));
		}
		scanner.close();
	}
}
