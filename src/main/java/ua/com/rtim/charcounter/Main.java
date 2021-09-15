package ua.com.rtim.charcounter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the close for exit");
		Cache cache = new Cache();
		while (!scanner.hasNext("close")) {
			String text = scanner.nextLine();
			if (text != null && !text.trim().isEmpty()) {
				CountingResult countingResult = cache.requaireCache(text, new TextSplitter());
				CharFormatter format = new CharFormatter();
				System.out.println(format.format(countingResult));
			}
		}
		System.out.println("Ok, good bye");
		scanner.close();
	}
}
