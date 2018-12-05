package edu.sjsu.cs.cs151.model;

import edu.sjsu.cs.cs151.controller.Message;
import java.util.concurrent.BlockingQueue;

/**
 * Class Model stores all the information about the current state of the game
 */
public class Model {
	private static BlockingQueue<Message> queue;
	private Chessboard board;

    public Model(BlockingQueue<Message> queue) {
    	this.queue = queue;
    }
    
    public void startGame() {
    	board = new Chessboard();
    }
    
    public Boolean move(int start, int end) {
    	System.out.println(start + ", " + end);
    	return false;
    }
}
