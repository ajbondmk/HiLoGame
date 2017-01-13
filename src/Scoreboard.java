public class Scoreboard {

	Score[] scores = new Score[10];

	public Scoreboard() {
		for (int i = 0; i < scores.length; i++) {
			scores[i] = new Score("", 0);
		}
	}

	public void print() {
		System.out.println("SCORE:\tNAME:");
		for (Score score : scores) {
			if (score.getScore() > 0 && score.getName() != "") {
				System.out.println(score.getScore() + "\t\t" + score.getName());
			}
		}
		System.out.println();
	}

	public void	insert(Score newEntry) {
		int newScore = newEntry.getScore();
		for (int i = 0; i < scores.length; i++) {
			if (scores[i].getScore() < newScore) {
				for (int j = i; j < scores.length; j++) {
					Score tempScore = scores[j];
					scores[j] = newEntry;
					newEntry = tempScore;
				}
			}
		}
	}

}