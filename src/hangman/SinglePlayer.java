package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class SinglePlayer {

	Tracker tracker;
	Hangman hangman;

	public void playSingle(Tracker tracker, Hangman hangman) {
		
		// Scanner to collect user input
		Scanner scanner = new Scanner(System.in);
		// a while loop
		while (tracker.attemptsCount < 7 && tracker.lettersRemained > 0) {

		
			System.out.println("Enter a letter or a word: ");
			String userEntry = scanner.nextLine().toUpperCase();

			// check if userEntry contains any symbols other than letters
			if (!userEntry.matches("[A-Z]+")) {
				System.out.println("Please, enter valid input");
			} else {

				// check if user entry is a word or a letter
				if (userEntry.length() > 1) {
					// when the user entered a word
					tracker.compareWord(userEntry);

					// the user entered one letter
				} else {

					// the word has a user entry letter
					if (tracker.guessWord.contains(userEntry)) {
						tracker.printGuessedLetters(userEntry, tracker);

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
		// to close the scanner
		scanner.close();
	}
}
