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

    public Model(BlockingQueue<Message> queue) {
    	Model.queue = queue;
    	board = new Chessboard();
    }
    
    public void startGame() {
    	board = new Chessboard();
    }
    
    public void resetGame() {
    	startGame();
    	Move.resetPlayTurn();
    }
    
    public void setMove(int start, int end) {
    	move = new Move(board, start, end);
    }
    
    public Move getMove() {
    	return move;
    }
}
