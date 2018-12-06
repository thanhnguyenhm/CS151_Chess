package edu.sjsu.cs.cs151.controller;

/**
* Handles Valve response to "end game" Message received from View 
*/

public class EndGameValve implements Valve {
	/**
	* ValveResponse execute method checks class types of incoming Messages 
	* and only executes them if they are a EndGameMessage. Called in Controller mainLoop
	* @param message from queue
	*/
	public ValveResponse execute(Message message)
	{
		if(message.getClass() != EndGameMessage.class)
		{
			return ValveResponse.MISS;
		}
		return ValveResponse.FINISH; // Will exit mainLoop in Controller
	}

}
