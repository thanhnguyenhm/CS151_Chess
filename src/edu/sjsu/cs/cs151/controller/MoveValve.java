package edu.sjsu.cs.cs151.controller;

import edu.sjsu.cs.cs151.model.Model;

/**
* Handles Valve response to move Message received from View
*/
import edu.sjsu.cs.cs151.view.View;

public class MoveValve implements Valve {
	private Model model;
	private View view;
	
	/**
	* MoveValve constructor 
	* @param Model, View
	*/
	public MoveValve(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	* ValveResponse execute method checks class types of incoming Messages 
	* and only executes them if they are a MoveMessage. Called in Controller mainLoop
	* @param message from queue
	*/
	public ValveResponse execute(Message message) {
		if(message.getClass() != MoveMessage.class)
			return ValveResponse.MISS;
		int s = ((MoveMessage) message).getStart();
		int e = ((MoveMessage) message).getEnd();
		model.setMove(s, e); // Set a move request that the Model will check for validity
		Boolean x = model.getMove().tryMove();
		if (x == true)
			view.viewMove(s, e);
		else
			view.dontMove(s, e);
		return ValveResponse.EXECUTED;
	}	
}
