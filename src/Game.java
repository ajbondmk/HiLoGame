import java.util.Scanner;

public class Game {

	private String name = "";

	private Round thisRound = null;

	private int score = 0;

	Scanner scanner;

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void play() {
		scanner = new Scanner(System.in);
		System.out.println("Welcome! Please type your name and press enter.");
		name = scanner.next();
		do {
			newRound();
		} while (requestNewRound());
		System.out.println("Thanks for playing!");
	}

	private void newRound() {
		System.out.println("New round begins!");
		boolean difficultySet = false;
		while (!difficultySet) {
			System.out.println("Please enter a difficulty level from 1 to 5, where 1 is easy and 5 is difficult.");
			String input = scanner.next();
			try {
				int difficulty = Integer.parseInt(input);
				if (difficulty >= 1 && difficulty <= 5) {
					thisRound = new Round(difficulty);
					difficultySet = true;
				}
				else System.out.println("Input out of range.");
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid input.");
			}
		}
		boolean roundInPlay = true;
		while (roundInPlay) {
			int max = thisRound.getDifficulty()*10;
			System.out.println("Guess my number (between 1 and " + max + "), " + thisRound.getGuessesRemaining() + " guesses remaining...");
			String input = scanner.next();
			try {
				int guess = Integer.parseInt(input);
				if (guess >= 1 && guess <= max) {
					switch (thisRound.checkGuess(guess)) {
						case tooLow:
							System.out.println("Your guess was too low!");
							break;
						case tooHigh:
							System.out.println("Your guess was too high!");
							break;
						case gameOver:
							System.out.println("You ran out of guesses, this round is over!");
							roundInPlay = false;
							break;
						case correct:
							System.out.println("You guessed correctly! The answer was " + guess + ".");
							roundInPlay = false;
							break;
					}
				}
				else System.out.println("Your guess was out of range! Try again.");
			}
			catch (NumberFormatException e) {
				System.out.println("Invalid input, please enter an integer.");
			}
		}
	}

	private boolean requestNewRound() {
		score += thisRound.getDifficulty()*thisRound.getGuessesRemaining();
		while (true) {
			System.out.println("Do you want to play another round? (y/n)");
			switch (scanner.next().toUpperCase()) {
				case "Y":
					return true;
				case "N":
					return false;
				default:
					System.out.println("Invalid input.");
					break;
			}
		}
	}

}