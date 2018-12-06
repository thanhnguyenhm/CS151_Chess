package edu.sjsu.cs.cs151.controller;

import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import edu.sjsu.cs.cs151.model.Model;
import edu.sjsu.cs.cs151.view.View;

/**
 * The Controller class synchronizes information between the Model and View classes
 * to control the state of the game. Receives Messages from View, then updates Model
 */
public class Controller {
    private List<Valve> valves = new LinkedList<Valve>();
	private BlockingQueue<Message> queue;
	private static Model model;
	private static View view;
	
    /**
     * Controller Constructor
     * @param View, Model, and BlockingQueue 
     */
    public Controller(BlockingQueue<Message> queue, Model model, View view) {
    	valves.add(new NewGameValve());
    	valves.add(new MoveValve(model, view));
    	valves.add(new EndGameValve());
    	this.queue = queue;
    	this.model = model;
    	this.view = view;
    }
    
    /**
     * Getter for model
     * @return model
     */
    public static Model getModel() {
        return model;
    }

    /**
     * Getter for view
     * @return view
     */
    public static View getView() {
        return view;
    }
    
    /**
    * Takes Messages from queue and processes them in FIFO order
    */
	public void mainLoop() throws Exception {
		ValveResponse response = ValveResponse.EXECUTED;
		Message message = null;
		while (response != ValveResponse.FINISH) {
			try {
				message = queue.take();		
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (Valve valve: valves) {
				response = valve.execute(message);
				if(response != ValveResponse.MISS)
					break;
			}
		}
	}
}
