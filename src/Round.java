public class Round {

	private int targetNumber;
	private int difficulty;
	private int guessesRemaining;

	public int getDifficulty() {
		return difficulty;
	}

	public int getGuessesRemaining() {
		return guessesRemaining;
	}

	public Round(int difficulty) {
		this.difficulty = difficulty;
		targetNumber = (int)((Math.random()*10*this.difficulty)+1);
		guessesRemaining = 5;
	}

	public GuessType checkGuess(int guess) {
		if (guess == targetNumber) return GuessType.correct;
		guessesRemaining--;
		if (guessesRemaining == 0) return GuessType.gameOver;
		if (guess < targetNumber) return GuessType.tooLow;
		return GuessType.tooHigh;
	}

}