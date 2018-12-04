package edu.sjsu.cs.cs151.game;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sjsu.cs.cs151.controller.Controller;
import edu.sjsu.cs.cs151.controller.Message;
import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

/**
 * This program is to create a 2-player Chess game
 * Team project for SJSU CS151
 */
public class Game {
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;
	
	// Method to call queue so it can be shared
	public static BlockingQueue<Message> getQueue() {
 		return queue;
 	}
	
    public static void main(String[] args) throws Exception {
        view = new View(); 
        // view = View.init(queue); <- Should share queue w/ View
        model = new Model();
        Controller game = new Controller(view, model, queue);
        game.mainLoop();
        view.dispose();
        view.dispose();
        queue.clear();
    }
}


