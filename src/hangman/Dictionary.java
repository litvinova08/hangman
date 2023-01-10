package hangman;

public class Dictionary {

	public char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	public String[] words = { "CAT", "BANANAS", "PLANET", "COLES", "AUSTRALIA" };

	public String[] getEmptyWord(String guessWord) {
		int wordLength = guessWord.length();
		String[] guessWordEmpty = new String[wordLength];
		for (int i = 0; i < wordLength; i++) {
			guessWordEmpty[i] = "_";
		}
		return guessWordEmpty;
	}
}
