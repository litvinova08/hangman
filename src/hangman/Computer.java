package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Computer {

	Tracker tracker;

	public void playWithComputer(Tracker tracker) {

		System.out.println("Playing with the computer");
		Scanner scanner = new Scanner(System.in);

		// move = 1 is computer turn; move = 0 is user turn
		int move = 0;

		while (tracker.attemptsCount < 7 && tracker.lettersRemained > 0) {

			if (move == 0) {
				System.out.println("User, enter a letter or a word: ");
				String userEntry = scanner.nextLine().toUpperCase();
				play(userEntry, tracker, move);
				move = 1;
			}

			else {

				int computerGuessIndex = (int) (Math.random() * Dictionary.alphabet.length);
				String computerGuess = String.valueOf(Dictionary.alphabet[computerGuessIndex]);
				System.out.println("Computer guess..." + computerGuess);
				play(computerGuess, tracker, move);
				move = 0;
			}
		}
		scanner.close();
	}

	public static void play(String entry, Tracker tracker, int move) {
		// check if userEntry contains any symbols other than letters
		if (!entry.matches("[A-Z]+")) {
			System.out.println("User, please, enter valid input");
		} else {

			// check if the user attempted to guess a word
			if (entry.length() > 1) {
				tracker.compareWord(entry);

				// the user entered one letter
			} else {
				// the word has a user entry letter
				if (tracker.guessWord.contains(entry)) {
					tracker.trackGuessedLetters(entry);

					// the word does not have a user entry letter
				} else {
					Hangman.printHangman(tracker.attemptsCount);
					tracker.attemptsCount = tracker.attemptsCount + 1;

					if (move == 0) {
						tracker.attemptsCountUser = tracker.attemptsCountUser + 1;
						System.out.println("You have " + (7 - tracker.attemptsCountUser) + " attempts left " + " and "
								+ tracker.lettersRemained + " letters to guess");
					} else {
						tracker.attemptsCountComputer = tracker.attemptsCountComputer + 1;
						System.out.println("Computer " + (7 - tracker.attemptsCountComputer) + " attempts left "
								+ " and " + tracker.lettersRemained + " letters to guess");
					}
				}
				System.out.println(Arrays.toString(tracker.guessWordEmpty));
			}
		}

	}
}
