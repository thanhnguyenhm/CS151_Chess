package edu.sjsu.cs.cs151.game;

import edu.sjsu.cs.cs151.controller.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;
import edu.sjsu.cs.cs151.controller.Controller;

/**
 * This program is to create a 2-player Chess game
 * Team project for SJSU CS151
 */
public class Game {
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();
	private static Model model;
	private static View view;
	
    public static void main(String[] args) throws Exception {   
    	model = new Model(queue);
    	view = new View(queue);
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
        view.dispose();
        queue.clear();
    }
}


