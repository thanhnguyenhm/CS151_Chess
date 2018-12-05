package edu.sjsu.cs.cs151.controller;

/**
* Handles Valve response to "end game" Message received from View to Model.
*/

public abstract class EndGameValve implements Valve {
	public ValveResponse execute(Message message)
	{
		if(message.getClass() != EndGameMessage.class)
		{
			return ValveResponse.MISS;
		}
		// TODO: actions in Model
		// TODO: actions in View
		return ValveResponse.EXECUTED;
	}

}
