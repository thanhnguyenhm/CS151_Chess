package edu.sjsu.cs.cs151.game;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.xml.internal.ws.api.message.Message; //is this the right one?

import edu.sjsu.cs.cs151.controller.Controller;
import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

/**
 * This program is to create a 2-player Chess game
 * Team project for SJSU CS151
 */
public class Game {
	// Should the BlockingQueue be public so we can share it among the View and Controller?
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static View view;
	private static Model model;
	
	public static BlockingQueue<Message> getQueue() {
		return queue;
	}
	
    public static void main(String[] args) throws Exception {
        view = new View(); // view = View.init(queue); <- From lecture slides. How should we init shared queue in the view?
        model = new Model();
        Controller game = new Controller(view, model, queue);
        game.mainLoop();
        view.dispose();
        queue.clear();      
    }
}


