import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scoreboard scoreboard = new Scoreboard();
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.println("Do you want to play (p), view the scoreboard (s), or quit (q)?");
			String input = scanner.next();
			switch (input.toUpperCase()) {
				case "Q":
					System.out.println("See you next time!");
					quit = true;
					break;
				case "S":
					scoreboard.print();
					break;
				case "P":
					Game thisGame = new Game();
					thisGame.play();
					scoreboard.insert(new Score(thisGame.getName(), thisGame.getScore()));
					break;
			}
		}
	}

}