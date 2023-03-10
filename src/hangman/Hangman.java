package hangman;

public class Hangman {

	public static String[][] hangman = { { " ------", "|     |", "|", "|", "|", "|", "|", "|", "----------" },
			{ " ------", "|     |", "|     0", "|     +", "|", "|", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|    -+-", "|", "|", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|", "|", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|     |", "|     |", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|     |", "|     |", "|    |", "|    |", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|     |", "|     |", "|    | |", "|    | |",
					"----------" } };

	public static void printHangman(int attemptsCount) {
		String[] partToPrint = hangman[attemptsCount];
		for (int i = 0; i < partToPrint.length; i++) {
			System.out.println(partToPrint[i]);
		}
	}
}
