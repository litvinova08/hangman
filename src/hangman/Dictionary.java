package hangman;

public class Dictionary {

	public static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	public static String[] words = { "CAT", "BANANAS", "PLANET", "COLES", "AUSTRALIA" };

	public static String[] getEmptyWord(String guessWord) {
		int wordLength = guessWord.length();
		String[] guessWordEmpty = new String[wordLength];
		for (int i = 0; i < wordLength; i++) {
			guessWordEmpty[i] = "_";
		}
		return guessWordEmpty;
	}
	
	public static String getAWord() {
		int IndexForWords = (int) (Math.random() * words.length);
		String guessWord = words[IndexForWords];
		return guessWord;
	}
}
