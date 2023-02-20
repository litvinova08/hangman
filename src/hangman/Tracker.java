package hangman;

import java.util.ArrayList;

public class Tracker {

	String userEntry;
	ArrayList<String> enteredLetters;
	String guessWord;
	String[] guessWordEmpty;
	int lettersRemained;
	int attemptsCount = 0;
	int attemptsCountUser = 0;
	int attemptsCountComputer = 0;

	public Tracker(ArrayList<String> enteredLetters, String guessWord, String[] guessWordEmpty, int lettersRemained) {
		this.enteredLetters = enteredLetters;
		this.guessWord = guessWord;
		this.guessWordEmpty = guessWordEmpty;
		this.lettersRemained = lettersRemained;
	}

	public void trackGuessedLetters(String userEntry) {

		// check if the user entered the letter previously
		if (this.enteredLetters.contains(userEntry)) {
			System.out.printf("You entered %s already. Please, enter another letter\n", userEntry);

		} else {
			// empty space will be replaced with e guessed letter
			for (int i = 0; i < this.guessWord.length(); i++) {
				if (this.guessWord.charAt(i) == userEntry.charAt(0)) {
					this.guessWordEmpty[i] = userEntry;
					this.lettersRemained--;
					this.enteredLetters.add(userEntry);
				}
			}
		}
	}

	// method to compare a useEntry word and a guess word if a user entered a word
	public void compareWord(String userEntry) {
		if (guessWord.equals(userEntry.toUpperCase())) {
			System.out.println("YOU guessed the word correctly, winner!!");
		} else {
			attemptsCount++;
			System.out.println("incorrect word guess");
		}
	}

	// to check if the user won or failed
	public void checkAttemps() {
		if (attemptsCountUser > 6 && lettersRemained > 0) {
			System.out.println("User failed, sorry");

		} else if (attemptsCountComputer > 6 && lettersRemained > 0) {
			System.out.println("Computer failed, sorry");

		} else if (attemptsCountUser < 7 && lettersRemained == 0) {
			System.out.println("User won!");
		} else if (attemptsCountComputer < 7 && lettersRemained == 0) {
			System.out.println("Computer won!");
		}
	}
}
