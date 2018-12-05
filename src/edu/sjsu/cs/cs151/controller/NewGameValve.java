package edu.sjsu.cs.cs151.controller;

/**
* Handles Valve response to new game Message received from View to Model.
*/	
public class NewGameValve implements Valve {
	public ValveResponse execute(Message message) {
		if(message.getClass() != NewGameMessage.class) {
			return ValveResponse.MISS;
		}
		message.ps();
		return ValveResponse.EXECUTED;
	}

}