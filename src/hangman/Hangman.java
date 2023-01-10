package hangman;

public class Hangman {

	public String[][] hangman = { { " ------", "|     |", "|", "|", "|", "|", "|", "|", "----------" },
			{ " ------", "|     |", "|     0", "|     +", "|", "|", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|    -+-", "|", "|", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|", "|", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|     |", "|     |", "|", "|", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|     |", "|     |", "|    |", "|    |", "----------" },

			{ " ------", "|     |", "|     0", "|   /-+-/", "|     |", "|     |", "|    | |", "|    | |",
					"----------" } };

	public Hangman() {
		this.hangman = hangman;
	}
	
	public void printHangman(int attemptsCount) {
		String[] partToPrint = hangman[attemptsCount];
		for (int i = 0; i < partToPrint.length; i++) {
			System.out.println(partToPrint[i]);
		}
	}
}
