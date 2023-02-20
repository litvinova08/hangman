package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class SinglePlayer {

	Tracker tracker;

	public void playSingle(Tracker tracker) {

		// Scanner to collect user input
		Scanner scanner = new Scanner(System.in);
		// a while loop
		while (tracker.attemptsCount < 7 && tracker.lettersRemained > 0) {

			System.out.println("Enter a letter or guess a word: ");
			String userEntry = scanner.nextLine().toUpperCase();

			if (validateInput(userEntry)){

				// check if user entry is a word or a letter
				if (userEntry.length() > 1) {
					tracker.compareWord(userEntry);

				} else {

					// the word has a user entry letter
					if (tracker.guessWord.contains(userEntry)) {
						tracker.trackGuessedLetters(userEntry);

						// the word does not have a user entry letter
					} else {
						Hangman.printHangman(tracker.attemptsCount);
						tracker.attemptsCount = tracker.attemptsCount + 1;
					}
					System.out.println("Attempts left: " + (7 - tracker.attemptsCount) + " | Letters to guess: "
							+ tracker.lettersRemained);
					System.out.println(Arrays.toString(tracker.guessWordEmpty));
				}
			}
		}
		scanner.close();
	}

	public static boolean validateInput(String userEntry) {
		if (!userEntry.matches("[A-Z]+")) {
			System.out.println("Please, enter valid input");
			return false;
		} else {
			return true;
		}
	}
}
