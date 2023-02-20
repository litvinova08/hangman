package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Do you want to play with the computer (type 1) or on your own (type 2)?");

		// scan user reply
		Scanner scannerMode = new Scanner(System.in);
		int playMode = scannerMode.nextInt();

		while (playMode != 1 && playMode != 2) {
			System.out.println("Please, choose one of the options");
			playMode = scannerMode.nextInt();
		}

		if (playMode == 1 || playMode == 2) {

			String guessWord = Dictionary.getAWord();

			// get an array with empty letter s("_") of the same length as a random word
			String[] guessWordEmpty = Dictionary.getEmptyWord(guessWord);

			// log an empty array of the same length as a random word to console
			System.out.println("word to guess " + Arrays.toString(guessWordEmpty));

			// counter of remaining letters
			int lettersRemained = guessWord.length();

			// ArrarList to store letters the user has already entered
			ArrayList<String> enteredLetters = new ArrayList<>();

			// a user tracker object
			Tracker tracker = new Tracker(enteredLetters, guessWord, guessWordEmpty, lettersRemained);

			// play user VS computer if 1 or single game if 2
			if (playMode == 1) {
				Computer computer = new Computer();
				computer.playWithComputer(tracker);
				tracker.checkAttemps();

			} else if (playMode == 2) {
				SinglePlayer singlePlayer = new SinglePlayer();
				singlePlayer.playSingle(tracker);
				tracker.checkAttemps();
			}
		}
		scannerMode.close();
	}
}