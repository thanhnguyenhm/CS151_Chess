package edu.sjsu.cs.cs151.model;

import edu.sjsu.cs.cs151.controller.Message;
import java.util.concurrent.BlockingQueue;

/**
 * Class Model stores all the information about the current state of the game
 */
public class Model {
	private static BlockingQueue<Message> queue;
	private Chessboard board;
	private Move move;

	/**
	 * Instantiate queue and chess board in the Model 
	 * @param queue for Messages sent from View
	 */
    public Model(BlockingQueue<Message> queue) {
    	Model.queue = queue;
    	board = new Chessboard();
    }
    
	/**
	 * Start the game by creating the chess board
	 */
    public void startGame() {
    	board = new Chessboard();
    }
    
	/**
	 * Reset game by making new chess board and resetting PlayTurn (white goes first) in Model
	 */  
    public void resetGame() {
    	startGame();
    	Move.resetPlayTurn();
    }
    
	/**
	 * Set a new move request that Move will check based on legal moves for piece
	 * @param start position
	 * @param end position
	 */
    public void setMove(int start, int end) {
    	move = new Move(board, start, end);
    }
    
	/**
	 * Return the move requested
	 * @return move
	 */
    public Move getMove() {
    	return move;
    }
}
