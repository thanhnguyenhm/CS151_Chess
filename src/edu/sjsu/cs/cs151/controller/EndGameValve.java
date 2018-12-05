package edu.sjsu.cs.cs151.controller;

/**
* Handles Valve response to "end game" Message received from View 
*/

public class EndGameValve implements Valve {
	public ValveResponse execute(Message message)
	{
		if(message.getClass() != EndGameMessage.class)
		{
			return ValveResponse.MISS;
		}
		return ValveResponse.FINISH;
	}

}
