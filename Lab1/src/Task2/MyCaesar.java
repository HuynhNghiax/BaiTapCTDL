package Task2;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	public char encryptChar(char c) {
		if (Character.isLetter(c)) {
			char base = Character.isUpperCase(c) ? 'A' : 'a';
			int index = (c - base + n) % 26;
			if (index < 0) {
				index += 26;
			}
			return (char) (base + index);
		}
		return c;
	}

	public String encrypt(String input) {
		StringBuilder result = new StringBuilder();

		for (char c : input.toCharArray()) {
			result.append(encryptChar(c));
		}

		return result.toString();
	}

	public char decryptChar(char c) {
		if (Character.isLetter(c)) {
			char base = Character.isUpperCase(c) ? 'A' : 'a';
			int index = (c - base - n) % 26;
			if (index < 0) {
				index += 26;
			}
			return (char) (base + index);
		}
		return c;
	}

	public String decrypt(String input) {
		StringBuilder result = new StringBuilder();

		for (char c : input.toCharArray()) {
			result.append(decryptChar(c));
		}

		return result.toString();
	}
}
