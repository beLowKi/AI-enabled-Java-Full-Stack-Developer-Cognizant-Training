package main;

public class SnakeGameDriver {

	public static void main(String[] args) {
		
		// TODO get from user input
		final int boardSize = 8;
		
		final SnakeGame game = new SnakeGame(boardSize);
		
		// TODO game loop until game.step() returns false
		
		game.displayBoard();
	}

}
