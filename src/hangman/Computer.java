package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Computer {

	Tracker tracker;
	Hangman hangman;

	public void playWithComputer(Tracker tracker, Hangman hangman, Dictionary dictionary) {
		
		System.out.println("Playing with the computer");

		// Scanner to collect user input
		Scanner scanner = new Scanner(System.in);
		
		// move = 1 is computer turn; move = 0 is user turn
		int move = 0;
		
		// a while loop
		while (tracker.attemptsCount < 7 && tracker.lettersRemained > 0) {

			if (move == 0) {
				System.out.println("Enter a letter or a word: ");
				String userEntry = scanner.nextLine().toUpperCase();
				play(userEntry, tracker, hangman);
				move = 1;
			}

			else {

				int computerGuessIndex = (int) (Math.random() * dictionary.alphabet.length);
				String computerGuess = String.valueOf(dictionary.alphabet[computerGuessIndex]);
				System.out.println("Computer guess..." + computerGuess);
				play(computerGuess, tracker, hangman);
				move = 0;
			}
		}

		// to close the scanner
		scanner.close();
	}

	
	public static void play(String entry, Tracker tracker, Hangman hangman) {
		// check if userEntry contains any symbols other than letters
		if (!entry.matches("[A-Z]+")) {
			System.out.println("Please, enter valid input");
		} else {

			// check if user entry is a word or a letter
			if (entry.length() > 1) {
				// when the user entered a word
				tracker.compareWord(entry);

				// the user entered one letter
			} else {

				// the word has a user entry letter
				if (tracker.guessWord.contains(entry)) {
					tracker.printGuessedLetters(entry, tracker);

					// the word does not have a user entry letter
				} else {
					hangman.printHangman(tracker.attemptsCount);
					tracker.attemptsCount = tracker.attemptsCount + 1;
				}
				System.out.println("You have " + (7 - tracker.attemptsCount) + " attempts left "
						+ " and you need to guess " + tracker.lettersRemained);
				System.out.println(Arrays.toString(tracker.guessWordEmpty));
			}
		}

	}
}
