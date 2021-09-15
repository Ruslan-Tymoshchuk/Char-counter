package ua.com.rtim.charcounter;

public class Character {

	private final String symbol;
	private final int amount;

	public Character(String symbol, int amount) {
		this.symbol = symbol;
		this.amount = amount;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getAmount() {
		return amount;
	}
}
