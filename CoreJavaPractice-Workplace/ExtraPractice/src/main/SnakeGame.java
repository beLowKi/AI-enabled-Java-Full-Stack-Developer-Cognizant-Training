package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * 
 */
public class SnakeGame {
	
	public enum Direction {
		UP, RIGHT, LEFT, DOWN
	}
	
	private enum CellType {
		EMPTY, SNAKE, APPLE
	}

	class Cell{
		int x;
		int y;
		CellType type;
		
		Cell(int x, int y) {
			this.x = x;
			this.y = y;
			this.type = CellType.EMPTY;
		}
		
		Cell(int x, int y, CellType type) {
			this(x, y);
			this.type = type;
		}
		
		@Override
		public String toString() {
			final String color = SnakeGame.CELL_TYPE_COLORS.get(this.type); 
//			System.out.println("Color of " + this.type + " -> " + color);
			return color + "(" + this.x + ", " + this.y + ")\u001B[0m";
		}
		
		@Override
		public Cell clone() {
			return new Cell(this.x, this.y, this.type);
		}
	}
	
	
	public static final Map<CellType, String> CELL_TYPE_COLORS = new HashMap<>(Map.of(
			CellType.SNAKE, "\u001B[32m",
			CellType.APPLE, "\u001B[31m",
			CellType.EMPTY, "\u001B[37m"
	));
	
	
	private CellType[][] board;
	private List<Cell> snake = new ArrayList<>();
	private Direction snakeDir;
	private Random rng;
	
	
	SnakeGame(int size) {
		this.board = new CellType[size][size];
		this.init();
	}
	
	
	private void init() {
		
		// RNG setup LocalDate.now().toEpochDay()
		this.rng = new Random();
		
		// Filling board with empty tiles
		for ( int y = 0; y < this.board.length; y++ ) {
			for ( int x = 0; x < this.board.length; x++  ) {
				this.board[y][x] = CellType.EMPTY;
			}
		}
		
		// Placing snake at random spot
		// TODO make sure this isn't at edge of board
		this.snake.clear();
		final Cell snakeHead = this.getRandomCell(CellType.EMPTY);
		this.addSnakeSegment(snakeHead);
		
		// Setting random start direction
		// TODO make sure this isn't pointing towards nearest edge
		final Direction[] dirs = Direction.values();
		this.snakeDir = dirs[this.rng.nextInt(dirs.length)];
		
		// Placing apple
		// TODO? make sure this isn't at edge of board
		final Cell apple = this.getRandomCell(CellType.EMPTY);
		this.setCell(apple, CellType.APPLE);
		
		// TODO for all these "make sure not on edge" randoms,
		// could overload getRandomCell to accept bounds for x and y.
	}
	
	public boolean step() {
		// TODO move snake segments
		// TODO check if head would overlap with
		// apple or hit edge of board
		
		return false;
	}
	
	public void displayBoard() {
		
		// TODO print board state
//		System.out.println(this.board);
		
		for ( int y = 0; y < this.board.length; y++ ) {
			for ( int x = 0; x < this.board.length; x++  ) {
//				System.out.print(this.board[y][x] + " ");
				
				final Cell c = new Cell(x, y, this.board[y][x]);
				System.out.print(c + " ");
			}
			
			System.out.print('\n');
		}
		
		System.out.println("\nSnake Direction: " + this.snakeDir);
		
	}
	
	private void setCell(Cell c) throws IndexOutOfBoundsException {
		if ( !this.isValidCell(c) ) {
			throw new IndexOutOfBoundsException("Cell " + c + " does not exist in board of size " + this.board.length);
		}
		
		this.board[c.y][c.x] = c.type;
	}
	
	private void setCell(Cell c, CellType type) throws IndexOutOfBoundsException {
		if ( !this.isValidCell(c) ) {
			throw new IndexOutOfBoundsException("Cell " + c + " does not exist in board of size " + this.board.length);
		}
		
		this.board[c.y][c.y] = type;
	}
	
	private void addSnakeSegment(Cell c) {
		final Cell seg = c.clone();
		seg.type = CellType.SNAKE;
		this.snake.add(seg);
		this.setCell(seg);
	}
	
	private Cell getRandomCell() {
		final int x = this.rng.nextInt(this.board.length - 1);
		final int y = this.rng.nextInt(this.board.length - 1);
		return new Cell(x, y, this.board[y][x]);
	}
	
	private Cell getRandomCell(CellType type) {
		Cell c = null;
		
		//FIXME gonna need to verify that a cell of
		//the desired type even exists
		while (!(c != null && c.type == type)) {
			c = this.getRandomCell();
		}
		
		return c;
	}
	
	private boolean isValidCell(Cell c) {
		return c.x < this.board.length && c.y < this.board.length;
	}
}
