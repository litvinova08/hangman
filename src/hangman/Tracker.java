package hangman;

import java.util.ArrayList;

public class Tracker {

	String userEntry;
	ArrayList<String> enteredLetters;
	String guessWord;
	String[] guessWordEmpty;
	int lettersRemained;
	int attemptsCount = 0;
//	int attemptsCountComputer = 0;

	public Tracker(ArrayList<String> enteredLetters, String guessWord, String[] guessWordEmpty, int lettersRemained) {
		this.enteredLetters = enteredLetters;
		this.guessWord = guessWord;
		this.guessWordEmpty = guessWordEmpty;
		this.lettersRemained = lettersRemained;
	}

	public void printGuessedLetters(String userEntry, Tracker tracker) {

		// check if the user entered the letter previously
		if (tracker.enteredLetters.contains(userEntry)) {
			System.out.printf("You entered %s already. Please, enter another letter\n", userEntry);

			// if the letter used the first time
		} else {

			// loop through a guess word to get an index of a user letter and replace an
			// empty symbol so the user can see an outcome
			for (int i = 0; i < tracker.guessWord.length(); i++) {
				if (tracker.guessWord.charAt(i) == userEntry.charAt(0)) {
					tracker.guessWordEmpty[i] = userEntry;
					tracker.lettersRemained--;
					tracker.enteredLetters.add(userEntry);
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
		if (attemptsCount > 6 && lettersRemained > 0) {
			System.out.println("You failed, sorry");

		} else if (attemptsCount < 7 && lettersRemained == 0) {
			System.out.println("You won!");
		}
	}
}
