package edu.sjsu.cs.cs151.controller;

/**
* Handles Valve response to new game Message received from View
*/	
public class NewGameValve implements Valve {
	/**
	* ValveResponse execute method compares class types of incoming Messages 
	* and only executes them if they are a NewGameMessage. Called in Controller mainLoop
	* @param message from queue
	*/
	public ValveResponse execute(Message message) {
		if(message.getClass() != NewGameMessage.class) {
			return ValveResponse.MISS;
		}
		return ValveResponse.EXECUTED;
	}
}